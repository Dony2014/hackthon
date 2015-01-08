package com.oracle.hackthon.controller;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.oracle.hackthon.dao.ChargeRepository;
import com.oracle.hackthon.dao.FileRepository;
import com.oracle.hackthon.dao.OwnRepository;
import com.oracle.hackthon.dao.UserRepository;
import com.oracle.hackthon.model.Account;
import com.oracle.hackthon.model.Charge;
import com.oracle.hackthon.model.FileUpload;
import com.oracle.hackthon.model.Own;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FileRepository fileRepository;

    @Autowired
    private OwnRepository ownRepository;

    @Autowired
    private ChargeRepository chargeRepository;


    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String DisplayForm() {
        return "uploadfile";
    }

    @RequestMapping(value = "/savefiles", method = RequestMethod.POST)
    public String Save(
            @ModelAttribute("uploadForm") FileUpload uploadForm,
            Model map) throws IllegalStateException, IOException {
        String currentWorkdirectory = System.getProperty("user.dir");
        String saveDirectory = currentWorkdirectory + "/upload/";

        File saveDirec = new File(saveDirectory);
        if (!saveDirec.exists()) {
            saveDirec.mkdirs();
        }

        List<MultipartFile> Files = uploadForm.getFiles();

        List<String> fileNames = new ArrayList<String>();

        if (null != Files && Files.size() > 0) {
            for (MultipartFile multipartFile : Files) {
                String fileName = multipartFile.getOriginalFilename();
                if (!"".equalsIgnoreCase(fileName)) {
                    addFileToDatabase(multipartFile);
                    multipartFile
                            .transferTo(new File(saveDirectory + fileName));
                    fileNames.add(fileName);
                }
            }
        }

        map.addAttribute("files", fileNames);
        return "uploadfilesuccess";
    }

    private void fileCalcuation(MultipartFile file, Long userId) {
        ;
        long fileSize = file.getSize();
        Account account = userRepository.findOne(userId);
        long oldRemain = account.getRemaining();
        account.setRemaining(oldRemain - fileSize);
        userRepository.saveAndFlush(account);
    }

    private void fileUpdate(MultipartFile file) {
        long fileSize = file.getSize();
        String name = file.getOriginalFilename();
        com.oracle.hackthon.model.File f = new com.oracle.hackthon.model.File();
        f.setFileName(name);
        f.setFileSize(fileSize);


        fileRepository.saveAndFlush(f);
    }

    private void ownUpdate(long user_id, String fileName) {
        Own o = new Own();
        long fileID = 0;
        for (com.oracle.hackthon.model.File file : fileRepository.findAll()) {
            if (file.getFileName().equals(fileName)) {
                fileID = file.getFileID();
            }
        }
        o.setAccountID(user_id);
        o.setFileID(fileID);
        ownRepository.saveAndFlush(o);
    }

    private void chargeCalculation(MultipartFile file, Long userId) {
        Charge chargeTab = chargeRepository.findOne((long) 1);
        long charge = chargeTab.getChargePerKB() * file.getSize();
        Account account = userRepository.findOne(userId);
        account.setCharge(charge);
        userRepository.saveAndFlush(account);
    }

    public void addFileToDatabase(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        Long userId = getOnlineUserID();

        fileUpdate(file);
        ownUpdate(userId, fileName);
        fileCalcuation(file, userId);
        chargeCalculation(file, userId);
    }


    public Long getOnlineUserID() {
        for (Account account : userRepository.findAll()) {
            if (account.getOnlineFlag() == 1) {
                return account.getAccountID();
            }
        }
        return (long) 0;

    }
}