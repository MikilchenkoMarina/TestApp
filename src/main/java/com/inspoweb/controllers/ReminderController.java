package com.inspoweb.controllers;

import com.inspoDataBase.entity.Reminder;
import com.inspoDataBase.entity.User;
import com.inspoDataBase.entity.forms.ReminderListForm;
import com.inspoDataBase.jpaUsageDataBase.service.ReminderService;
import com.inspoDataBase.jpaUsageDataBase.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.swing.*;
import javax.validation.Valid;
import java.util.ArrayList;
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

/*
    @RequestMapping(value = "/{id}/reminders", method = RequestMethod.GET)
    public String showReminderList(@PathVariable Integer id, Model model) {

        User user = userService.findUserByUserId(id);
        model.addAttribute("user", user);
        List<Reminder> reminderList = reminderService.findReminderByUser(user);

        ReminderListForm reminderListForm = new ReminderListForm();
        //reminderListForm.setReminderList(reminderList);

        model.addAttribute("reminderList", reminderList);
        model.addAttribute("reminderListForm", reminderListForm);
       // model.addAttribute("reminder", new Reminder());

        return "remindersPage";
    }*/

 /*   @RequestMapping(value = "/1/reminders"*//*, method = RequestMethod.POST*//*)
    public ModelAndView removeReminders(*//*@PathVariable Integer id,@ModelAttribute("reminderListForm") ReminderListForm reminderListForm,Model model*//*) {
        ModelAndView mav = new ModelAndView("remindersPage");

        List<Reminder> reminderList = reminderService.findReminderByUser(userService.findUserByUserId(1));
        mav.addObject("reminderList",reminderList);
        mav.addObject("reminderListForm",new ReminderListForm());


*//*        List<Reminder> selectedReminderList = reminderListForm.getReminderList();
        model.addAttribute("resultList",selectedReminderList);*//*

    *//*    for (Reminder reminder : selectedReminderList) {
            reminderService.deleteReminderById(reminder.getReminderId());
        }*//*
*//*
        if (resul.hasErrors()) {
            return "remindersPage";
        }*//*

        return mav;
    }
    @RequestMapping(value = "/1/sent-list"*//*, method = RequestMethod.GET*//*)
    public ModelAndView save(*//*@PathVariable Integer id,*//* @ModelAttribute("reminderListForm") ReminderListForm reminderListForm){

        ModelAndView mav = new ModelAndView("sent-list");
        mav.addObject("reminderListForm",reminderListForm);
      *//*  for(Reminder reminder : reminderListForm.getReminderList()){
            //make some computation here
        }*//*
        return mav;
    }
*/
}
