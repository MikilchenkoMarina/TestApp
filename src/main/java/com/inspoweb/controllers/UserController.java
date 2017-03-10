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
 * @author mmikilchenko on 27.02.2017.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    private UserService userService;
    private ReminderService reminderService;


    @Autowired
    public UserController(UserService userService, ReminderService reminderService) {
        this.userService = userService;
        this.reminderService = reminderService;

    }


    @RequestMapping(value = "/{userName}", method = RequestMethod.GET)
    public String showUserProfileByUserName(@PathVariable String userName, Model model) {
        User user = userService.findUserByUsername(userName);
        List<Reminder> userReminders = reminderService.findReminderByUser(user);
        model.addAttribute("user", user);
        model.addAttribute("reminderList", userReminders);
        model.addAttribute("reminder", new Reminder());
        return "profile";
    }

    @RequestMapping(value = "/{userName}", method = RequestMethod.POST)
    public String addReminderOnUserProfile(@PathVariable String userName, @Valid Reminder reminder, BindingResult resul) {

        User user = userService.findUserByUsername(userName);
        if (!resul.hasErrors()) {
            reminderService.addReminder(reminder, user);
        } else {
            JOptionPane pane = new JOptionPane();
            pane.requestFocusInWindow();
            pane.requestFocus();

            final JDialog d = pane.createDialog((JFrame) null, "Title");
            d.requestFocusInWindow();
            d.setFocusable(true);
            d.setLocation(10, 10);
            d.setVisible(true);
        }
        return "redirect:/user/{userName}";

    }

}
