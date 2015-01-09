package com.oracle.hackthon.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.oracle.hackthon.dao.FileRepository;
import com.oracle.hackthon.dao.OwnRepository;
import com.oracle.hackthon.dao.UserRepository;
import com.oracle.hackthon.model.Account;
import com.oracle.hackthon.model.Own;


@Controller
public class ShareController {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private FileRepository fileRepository;
	@Autowired
    private OwnRepository ownRepository;
	
	/** forward share page **/
	@RequestMapping(value = "/testShare", method = RequestMethod.GET)
    public String forwordShare(HttpServletRequest request, ModelMap model, HttpServletResponse response) {
		//System.out.println("file id : " + request.getParameter("id")); 
		model.addAttribute("file_id", request.getParameter("fileId"));
        return "share";
    }

	@RequestMapping(value = "/shareFile/{file_id}", method = RequestMethod.POST)
	public String requestShare(@PathVariable("file_id") Long fileId, HttpServletResponse response) {
		String shareUrl = "http://localhost:7001/hackthon/shareDown/";
		com.oracle.hackthon.model.File shareFile = fileRepository.findOne(fileId);
		
		
		return "redirect:/";
	}
	
	/** download shared file **/
	@RequestMapping(value = "/shareDown/{file_id}", method = RequestMethod.GET)
	public void shareDown(@PathVariable("file_id") Long fileId, HttpServletResponse response) {
		response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        System.out.println("file 1 :" + fileId );
        response.setHeader("Content-Disposition", "attachment;fileName=" + getFileName(fileId));
        try {

            System.out.println("file 1 :" + fileId );
            System.out.println("file name :" + getFileName(fileId) );
            String path = System.getProperty("user.dir") + File.separator + "upload" + File.separator + getFileName(fileId);

            System.out.println("file path :" + path );
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
	
	/** save file to my page **/
	@RequestMapping(value = "/shareSaveToMe/{file_id}", method = RequestMethod.GET)
	public String shareSaveToMe(@PathVariable("file_id") Long fileId) {
		Own own = new Own();
		
        for (Account account : userRepository.findAll()) {
            
            if(account.getOnlineFlag() == 1)
            	own.setAccountID(account.getAccountID());
        }

        own.setFileID(fileId);
        ownRepository.save(own);
		
		return "redirect:/";
	}
	
	public String getFileName(Long fileId){

        return fileRepository.findOne(fileId).getFileName();
    }
}
