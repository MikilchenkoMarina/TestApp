package com.inspoweb.controllers;

import com.inspoDataBase.entity.User;
import com.inspoDataBase.jpaUsageDataBase.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Optional;

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

    //registration
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

        return "redirect:/user/" + user.getUserId();
    }

    //login
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());

        return "loginForm";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String processLogin(@Valid User user, BindingResult resul) {
        User existedUser = userService.findUserByUsernameAndPassword(user.getUserName(), user.getPassword());
        if (existedUser == null || resul.hasErrors()) {
            return "loginForm";
        }

  /*      return Optional.ofNullable("redirect:/user/" + existedUser.getUserId())
                .orElse("loginForm");*/
        return "redirect:/user/" + existedUser.getUserId();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String showUserProfile(@PathVariable Integer id, Model model) {
        User user = userService.findUserByUserId(id);
        model.addAttribute("user", user);

        return "profile";
    }


}
