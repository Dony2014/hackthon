       package com.oracle.hackthon.controller;

        import com.oracle.hackthon.dao.ChargeRepository;
        import com.oracle.hackthon.dao.OwnRepository;
        import com.oracle.hackthon.model.Account;
        import com.oracle.hackthon.model.Charge;
        import com.oracle.hackthon.model.Own;
        import org.apache.commons.io.IOUtils;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;

        import com.oracle.hackthon.dao.FileRepository;
        import com.oracle.hackthon.dao.UserRepository;
        import org.springframework.web.multipart.MultipartFile;

        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;

        import java.io.*;

/**
 * Created by Dony on 1/8/2015.
 */
@Controller
public class FileDownloadConroller {
    @Autowired
    private FileRepository userFileRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FileRepository fileRepository;

    @Autowired
    private OwnRepository ownRepository;

    @Autowired
    private ChargeRepository chargeRepository;

    @RequestMapping(value = "/downloadfile", method = RequestMethod.GET)
    public String DisplayForm() {
        return "downloadfile";
    }


    @RequestMapping(value = "/downloadfile/{file_id}", method = RequestMethod.GET)
    public void getFile(@PathVariable("file_id") Long fileId, HttpServletResponse response) {
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;fileName=" + getFileName(fileId));
        try {

            //System.out.println("file 1 :" + fileId );
            //System.out.println("file name :" + getFileName(fileId) );
            String path = System.getProperty("user.dir") + File.separator + "upload" + File.separator + getFileName(fileId);

            //System.out.println("file path :" + path );
            File directory = new File(path);

            InputStream inputStream = new FileInputStream(directory);
            // copy it to response's OutputStream
            IOUtils.copy(inputStream, response.getOutputStream());
            response.flushBuffer();
        } catch (IOException ex) {
            //log.info("Error writing file to output stream. Filename was '{}'", fileName, ex);
            throw new RuntimeException("IOError writing file to output stream");
        }

    }


    public String getFileName(Long fileId){

        return this.userFileRepository.findOne(fileId).getFileName();
    }



    /** ---------------------------
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
        String name =  file.getOriginalFilename();
        com.oracle.hackthon.model.UserFile f = new com.oracle.hackthon.model.UserFile();
        f.setFileName(name);
        f.setFileSize(fileSize);


        fileRepository.saveAndFlush(f);
    }

    private void ownUpdate(long user_id, String fileName) {
        Own o = new Own();
        long fileID = 0;
        for (com.oracle.hackthon.model.UserFile file : fileRepository.findAll()) {
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


    public Long getOnlineUserID(){
        for (Account account : userRepository.findAll()) {
            if (account.getOnlineFlag()==1) {
                return account.getAccountID();
            }
        }
        return (long) 0;

    }
     ----------------**/
}
