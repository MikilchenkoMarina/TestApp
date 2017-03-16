package com.inspoweb.controllers;

import com.inspoDataBase.entity.Reminder;
import com.inspoDataBase.entity.User;
import com.inspoDataBase.jpaUsageDataBase.service.ReminderService;
import com.inspoDataBase.jpaUsageDataBase.service.UserService;
import com.inspoweb.utils.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.*;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;


/**
 * @author mmikilchenko on 27.02.2017.
 */
@Controller
@RequestMapping(value = "/user/{userName}/reminders")
public class ReminderController {

    @Autowired
    private FileUploadUtil fileUploadUtil;

    private UserService userService;
    private ReminderService reminderService;


    @Autowired
    public ReminderController(UserService userService, ReminderService reminderService) {
        this.userService = userService;
        this.reminderService = reminderService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showUserReminders(@PathVariable String userName, Model model) {
        User user = userService.findUserByUsername(userName);
        List<Reminder> userReminders = reminderService.findReminderByUser(user);
        model.addAttribute("user", user);
        model.addAttribute("reminderList", userReminders);
        model.addAttribute("reminder", new Reminder());
        return "reminders";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addserReminders(@PathVariable String userName, @RequestParam("user-file") MultipartFile multipartFile, @Valid Reminder reminder, BindingResult resul) {
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
              return "reminders";
        }
        return "redirect:/user/{userName}/reminders";
    }

    @RequestMapping(value = "/{reminderId}", method = RequestMethod.GET)
    public String getReminder(@PathVariable Integer reminderId, Model model) {
        Reminder userReminder = reminderService.findReminderById(reminderId);
        model.addAttribute("reminder", userReminder);
        return "reminder";
    }

    @RequestMapping(value = "/{reminderId}", method = {RequestMethod.DELETE})
    //@ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteReminder(@PathVariable Integer reminderId) {
        reminderService.deleteReminderById(reminderId);
        return "redirect:/user/{userName}/reminders";
    }


}
