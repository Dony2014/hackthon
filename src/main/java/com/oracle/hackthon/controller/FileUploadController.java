package com.oracle.hackthon.controller;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.oracle.hackthon.model.FileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {

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

                    multipartFile
                            .transferTo(new File(saveDirectory + fileName));
                    fileNames.add(fileName);
                }
            }
        }

        map.addAttribute("files", fileNames);
        return "uploadfilesuccess";
    }
}