package com.inspoweb.controllers;

import com.inspoDataBase.entity.User;
import com.inspoDataBase.jpaUsageDataBase.service.UserService;
import com.sun.org.apache.bcel.internal.generic.GETFIELD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author mmikilchenko on 27.02.2017.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationForm() {
        return "registerForm";
    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegistration (User user){
        userService.addUser(user);
        return "redirect:/user/"+user.getUserId();
    }

    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public String showUserProfile (@PathVariable Integer id,Model model){
        User user =userService.findUserByUserId(id);
        model.addAttribute("user",user);
        return "profile";
    }


}
