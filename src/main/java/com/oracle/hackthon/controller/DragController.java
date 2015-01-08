package com.oracle.hackthon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Dony on 1/8/2015.
 */
@Controller
public class DragController {

    @RequestMapping(value = "/filedrag", method = RequestMethod.GET)
    public String DisplayDragtest() {
        return "filedrag";
    }

    @RequestMapping(value = "/dragtest_upload", method = RequestMethod.POST)
    public void upload(@RequestParam MultipartFile[] files,
                       HttpServletRequest request) {
        for (MultipartFile file : files) {
            if (file.isEmpty()) continue;
            System.out.println(file.getContentType() + "," +
                    file.getName() + "," + file.getOriginalFilename());
        }
    }

}
