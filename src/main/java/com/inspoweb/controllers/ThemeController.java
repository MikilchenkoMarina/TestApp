package com.inspoweb.controllers;

import com.inspoDataBase.jpaUsageDataBase.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * @author mmikilchenko on 24.02.2017.
 */
@Controller
public class ThemeController {
    public ThemeService themeService;

    @Autowired
    public ThemeController(ThemeService reminderService) {
        this.themeService = reminderService;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String reminders(Map<String,Object> model) {
        model.put("themeList",themeService.findAllThemas());

        return "theme";
    }


}
