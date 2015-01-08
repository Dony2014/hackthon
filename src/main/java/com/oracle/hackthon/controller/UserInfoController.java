package com.oracle.hackthon.controller;


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

@Controller
public class UserInfoController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private FileRepository fileRepository;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listUsers(ModelMap model) {
        model.addAttribute("account",new Account());
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
		return "homepage";// ///////////////////
	}

}