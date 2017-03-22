package com.inspoweb.controllers;

import com.inspoDataBase.entity.Reminder;
import com.inspoDataBase.entity.RemindersAppearDelay;
import com.inspoDataBase.entity.User;
import com.inspoDataBase.jpaUsageDataBase.service.ReminderService;
import com.inspoDataBase.jpaUsageDataBase.service.UserService;
import com.inspoweb.utils.FileUploadUtil;
import com.inspoweb.utils.schedule.ReminderTimer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;


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

        Map<Integer, String> delayMap = new HashMap<>();
        delayMap.put(10000, "10 sec");
        delayMap.put((int) TimeUnit.MINUTES.toMillis(10), "10 min");
        delayMap.put((int) TimeUnit.MINUTES.toMillis(20), "20 min");

        model.addAttribute("delayMap", delayMap);
        model.addAttribute("remindersAppearDelay", new RemindersAppearDelay());
        return "profile";
    }


    @RequestMapping(value = "/{userName}",method = RequestMethod.POST)
    public String runReminders(@PathVariable String userName, @ModelAttribute RemindersAppearDelay remindersAppearDelay,Authentication authentication,Model model) {

        model.addAttribute("selectedDelay", remindersAppearDelay.getDelay());
/*        User loggedUser= userService.findUserByUsername(authentication.getName());
        ReminderTimer reminderTimer = new ReminderTimer(loggedUser, reminderService, remindersAppearDelay.getDelay());

        try {
            reminderTimer.run();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        return "redirect:/user/{userName}";
    }



}
