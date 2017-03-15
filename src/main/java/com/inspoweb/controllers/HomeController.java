package com.inspoweb.controllers;

import com.inspoDataBase.entity.User;
import com.inspoDataBase.jpaUsageDataBase.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Optional;

/**
 * @author mmikilchenko on 01.03.2017.
 */
@Controller
@RequestMapping(value = {"/home", "/"})
public class HomeController {

    private UserService userService;

    @Autowired
    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showRegistrationForm() {

        return "home";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());

        return "registerForm";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegistration(@Valid User user, BindingResult resul) {
        userService.addUser(user);

        if (resul.hasErrors()) {
            return "registerForm";
        }

        return "redirect:/user/" + user.getUserName();
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginForm(Model model, String error, String logout, Authentication  authentication) {
        model.addAttribute("user", new User());
        if (error != null)
            model.addAttribute("error", "Your username or password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return  "login";
    }

}