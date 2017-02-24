package com.inspoweb.controllers;


import com.inspoweb.model.UserWeb;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MainController {


    @RequestMapping(value = "login", method = RequestMethod.GET)
    public ModelAndView main() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userJSP", new UserWeb());
        modelAndView.setViewName("login");
        return modelAndView;
    }


    @RequestMapping(value = "/welcome-user")
    public ModelAndView checkUser(@ModelAttribute("userJSP") UserWeb user) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("welcomePage");
        modelAndView.addObject("userJSP", user);
        return modelAndView;
    }
}
