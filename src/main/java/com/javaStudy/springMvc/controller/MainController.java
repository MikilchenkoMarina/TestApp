package com.javaStudy.springMvc.controller;

import com.javaStudy.springMvc.model.UserWeb;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class MainController {


    @RequestMapping(value = "one", method = RequestMethod.GET)
    public ModelAndView main() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userJSP", new UserWeb());
        modelAndView.setViewName("index");
        return modelAndView;
    }


    @RequestMapping(value = "/check-user")
    public ModelAndView checkUser(@ModelAttribute("userJSP") UserWeb user) {
        ModelAndView modelAndView = new ModelAndView();


        modelAndView.setViewName("secondPage");


        modelAndView.addObject("userJSP", user);
        return modelAndView;
    }
}
