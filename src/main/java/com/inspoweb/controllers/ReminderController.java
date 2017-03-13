package com.inspoweb.controllers;

import com.inspoDataBase.entity.Reminder;
import com.inspoDataBase.entity.User;
import com.inspoDataBase.jpaUsageDataBase.service.ReminderService;
import com.inspoDataBase.jpaUsageDataBase.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;


/**
 * @author mmikilchenko on 27.02.2017.
 */
@Controller
@RequestMapping(value = "/user/{id}/reminders")
public class ReminderController {
    private UserService userService;
    private ReminderService reminderService;


    @Autowired
    public ReminderController(UserService userService, ReminderService reminderService) {
        this.userService = userService;
        this.reminderService = reminderService;

    }


    @RequestMapping(method = RequestMethod.GET)
    public String showUserReminders(@PathVariable Integer id, Model model) {
        User user = userService.findUserByUserId(id);
        List<Reminder> userReminders = reminderService.findReminderByUser(user);
        model.addAttribute("user", user);
        model.addAttribute("reminderList", userReminders);
        model.addAttribute("reminder", new Reminder());
        return "reminders";
    }

    @RequestMapping(value = "/{reminderId}", method = RequestMethod.GET)
    public String getReminder(@PathVariable Integer reminderId, Model model) {
        Reminder userReminder = reminderService.findReminderById(reminderId);
        model.addAttribute("reminder", userReminder);
        return "reminder";
    }

    @RequestMapping(value = "/{reminderId}", method ={RequestMethod.DELETE})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteReminder(@PathVariable Integer reminderId) {
        reminderService.deleteReminderById(reminderId);
        return "redirect:/user/{id}/reminders";
    }


}
