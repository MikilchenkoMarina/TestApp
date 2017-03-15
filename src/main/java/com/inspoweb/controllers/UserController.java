package com.inspoweb.controllers;

import com.inspoDataBase.entity.Reminder;
import com.inspoDataBase.entity.User;
import com.inspoDataBase.jpaUsageDataBase.service.ReminderService;
import com.inspoDataBase.jpaUsageDataBase.service.UserService;
import com.inspoweb.utils.FileUploadUtil;
import com.inspoweb.utils.schedule.ReminderTimer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.*;
import javax.validation.Valid;
import java.io.IOException;
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
    private FileUploadUtil fileUploadUtil;


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

    @RequestMapping(value = "/{userName}", params = "action1", method = RequestMethod.POST)
    public String addReminderOnUserProfile(@PathVariable String userName, @RequestParam("user-file") MultipartFile multipartFile, @Valid Reminder reminder, BindingResult resul) {

        User user = userService.findUserByUsername(userName);
        if (!multipartFile.isEmpty()) {

            try {
                String amazonS3ImageUrl = fileUploadUtil.saveImageToAmazonS3(multipartFile, userName);
                reminder.setImageLink(amazonS3ImageUrl);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (!resul.hasErrors()) {
            reminderService.addReminder(reminder, user);
        } else {
            JOptionPane pane = new JOptionPane();
            final JDialog d = pane.createDialog((JFrame) null, "Title");
            d.requestFocusInWindow();
            d.setFocusable(true);
            d.requestFocus();
            d.setLocation(10, 10);
            d.setVisible(true);
        }
        return "redirect:/user/{userName}";

    }

    @RequestMapping(value = "/{userName}", params = "action2", method = RequestMethod.POST)
    public String action2(@PathVariable String userName, Authentication authentication) {

        User userTrue = userService.findUserByUsername(authentication.getName());
        ReminderTimer reminderTimer = new ReminderTimer(userTrue, reminderService);
        try {
            reminderTimer.run();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "redirect:/user/{userName}";
    }

}
