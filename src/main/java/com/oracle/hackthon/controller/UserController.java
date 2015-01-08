package com.oracle.hackthon.controller;

import com.oracle.hackthon.dao.UserRepository;
import com.oracle.hackthon.model.AccountTest;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listUsers(ModelMap model) {
        model.addAttribute("user", new AccountTest());
        model.addAttribute("users", userRepository.findAll());
        return "users";
    }

    @RequestMapping(value = "/api/users", method = RequestMethod.GET)
    public
    @ResponseBody
    String listUsersJson(ModelMap model) throws JSONException {
        JSONArray userArray = new JSONArray();
        for (AccountTest account : userRepository.findAll()) {
            JSONObject userJSON = new JSONObject();
            userJSON.put("id", account.getId());
            userJSON.put("firstName", account.getFirstName());
            userJSON.put("lastName", account.getLastName());
            userJSON.put("email", account.getEmail());
            userArray.put(userJSON);
        }
        return userArray.toString();
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") AccountTest account, BindingResult result) {
        userRepository.save(account);
        return "redirect:/";
    }

    @RequestMapping("/delete/{userId}")
    public String deleteUser(@PathVariable("userId") Long userId) {
        userRepository.delete(userRepository.findOne(userId));
        return "redirect:/";
    }
}