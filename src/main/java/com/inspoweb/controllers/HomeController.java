package com.inspoweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author mmikilchenko on 01.03.2017.
 */
@Controller
@RequestMapping(value = {"/home", "/"})
public class HomeController {


    @RequestMapping(method = RequestMethod.GET)
    public String showRegistrationForm() {
        return "homePage";
    }
}