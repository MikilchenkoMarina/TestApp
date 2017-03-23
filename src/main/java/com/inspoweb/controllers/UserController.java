package com.inspoweb.controllers;

import com.inspoDataBase.entity.Reminder;
import com.inspoDataBase.entity.RemindersAppearDelay;
import com.inspoDataBase.entity.User;
import com.inspoDataBase.jpaUsageDataBase.service.ReminderService;
import com.inspoDataBase.jpaUsageDataBase.service.UserService;
import com.inspoweb.utils.schedule.ReminderTimer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.LinkedHashMap;
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

        model.addAttribute("user", user);
        model.addAttribute("reminderList", reminderService.findReminderByUser(user));
        model.addAttribute("reminder", new Reminder());
        model.addAttribute("delayMap", getDelayMap());
        model.addAttribute("remindersAppearDelay", new RemindersAppearDelay());
        return "profile";
    }

    private Map<Integer, String> getDelayMap() {
        Map<Integer, String> delayMap = new LinkedHashMap<Integer, String>();
        delayMap.put(5000, "5 seconds (for demo)");
        delayMap.put((int) TimeUnit.MINUTES.toMillis(10), "10 minutes");
        delayMap.put((int) TimeUnit.MINUTES.toMillis(30), "30 minutes");
        delayMap.put((int) TimeUnit.MINUTES.toMillis(60), "1 hour");
        return delayMap;
    }


    @Deprecated

    // Jpanel - reminders via TimerTask and users thread, not supported on Heroku, re-maked via javaScript

/*    @RequestMapping(value = "/{userName}",method = RequestMethod.POST)*/
    public String runReminders(@PathVariable String userName, @ModelAttribute RemindersAppearDelay remindersAppearDelay, Authentication authentication, Model model) {

        //model.addAttribute("selectedDelay", remindersAppearDelay.getDelay());
        User loggedUser = userService.findUserByUsername(authentication.getName());
        ReminderTimer reminderTimer = new ReminderTimer(loggedUser, reminderService, remindersAppearDelay.getDelay());

        try {
            reminderTimer.run();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "redirect:/user/{userName}";
    }


}
