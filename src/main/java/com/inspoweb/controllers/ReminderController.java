package com.inspoweb.controllers;

import com.inspoDataBase.entity.Reminder;
import com.inspoDataBase.entity.User;
import com.inspoDataBase.jpaUsageDataBase.service.ReminderService;
import com.inspoDataBase.jpaUsageDataBase.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.swing.*;
import javax.validation.Valid;
import java.util.List;


/**
 * @author mmikilchenko on 03.03.2017.
 */
@Controller
@RequestMapping(value = "/user")
public class ReminderController {
    private UserService userService;
    private ReminderService reminderService;


    @Autowired
    public ReminderController(UserService userService, ReminderService reminderService) {
        this.userService = userService;
        this.reminderService = reminderService;

    }


    @RequestMapping(value = "/{id}/reminders", method = RequestMethod.GET)
    public String showReminderList(@PathVariable Integer id, Model model) {

        User user = userService.findUserByUserId(id);
        model.addAttribute("user", user);
        model.addAttribute("reminderList", reminderService.findReminderByUser(user));
        model.addAttribute("reminder", new Reminder());

        return "remindersPage";
    }

    @RequestMapping(value = "/{id}/reminders", method = RequestMethod.POST)
    public String removeReminders(List<Reminder> reminderList, Model model, BindingResult resul) {
        for (Reminder reminder : reminderList) {
            reminderService.deleteReminderById(reminder.getReminderId());
        }

        if (resul.hasErrors()) {
            return "remindersPage";
        }

        return "remindersPage";
    }

}
