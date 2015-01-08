package com.oracle.hackthon.controller;


import com.oracle.hackthon.dao.OwnRepository;
import com.oracle.hackthon.model.File;
import com.oracle.hackthon.model.Own;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.oracle.hackthon.dao.FileRepository;
import com.oracle.hackthon.dao.UserRepository;
import com.oracle.hackthon.model.Account;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserInfoController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FileRepository fileRepository;
    @Autowired
    private OwnRepository ownRepository;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listUsers(ModelMap model) {
        model.addAttribute("account", new Account());
        return "login";
    }

    @RequestMapping(value = "requestLogin", method = RequestMethod.POST)
    public String userLogin(@ModelAttribute("user") Account account,
                            BindingResult result) {
        for (Account user : userRepository.findAll()) {
            if (user.getUsername().equals(account.getUsername())) {
                if (user.getPassword().equals(account.getPassword())) {
                    user.setOnlineFlag(1);
                    userRepository.saveAndFlush(user);
                    return "redirect:upload";

                }
            }
        }
        return "redirect:/";// ///////////////////
    }

    @RequestMapping(value = "/gohome", method = RequestMethod.GET)
    public String fileList(ModelMap model) {
        model.addAttribute("files", fileRepository.findAll());
        List<File> files = fileRepository.findAll();
        long userId = 1;
        for (Account user : userRepository.findAll()) {
            if (user.getOnlineFlag() == 1) {
                userId = user.getAccountID();
            }
        }
        List<Long> fileIds = new ArrayList<Long>();
        for (Own own : ownRepository.findAll()) {
            if (own.getAccountID() == userId) {
                fileIds.add(own.getFileID());
            }
        }
        for (File file : files) {
            if (!fileIds.contains(file.getFileID())) {
                files.remove(file);
            }
        }
        return "homepage";// ///////////////////
    }


}