package com.oracle.hackthon.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by Dony on 1/8/2015.
 */
@Controller
public class FileDownloadConroller {

    @RequestMapping(value = "/downloadfile", method = RequestMethod.GET)
    public String DisplayForm() {
        return "downloadfile";
    }


    @RequestMapping(value = "/downloadfile/{file_name}", method = RequestMethod.GET)
    public void getFile(@PathVariable("file_name") String fileName, HttpServletResponse response) {
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);
        try {

            String path = System.getProperty("user.dir") + File.separator + "upload";
            File directory = new File(path);
            if (directory.listFiles().length == 0) {
                new File(path + File.separator + "test.txt").createNewFile();
            }
            InputStream inputStream = new FileInputStream(directory.listFiles()[0]);
            // copy it to response's OutputStream
            IOUtils.copy(inputStream, response.getOutputStream());
            response.flushBuffer();
        } catch (IOException ex) {
            //log.info("Error writing file to output stream. Filename was '{}'", fileName, ex);
            throw new RuntimeException("IOError writing file to output stream");
        }

    }
}
