package com.inspoweb.controllers;

import com.inspoDataBase.entity.Reminder;
import com.inspoDataBase.entity.forms.ReminderListForm;
import com.inspoDataBase.jpaUsageDataBase.service.ReminderService;
import com.inspoDataBase.jpaUsageDataBase.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author mmikilchenko on 06.03.2017.
 */
@Controller
public class RemindersListController {

    private UserService userService;
    private ReminderService reminderService;

    public RemindersListController(UserService userService, ReminderService reminderService) {
        this.userService = userService;
        this.reminderService = reminderService;
    }


    @RequestMapping(value = "/reminders"/*, method = RequestMethod.POST*/)
    public ModelAndView removeReminders(/*@PathVariable Integer id,@ModelAttribute("reminderListForm") ReminderListForm reminderListForm,Model model*/) {
        ModelAndView mav = new ModelAndView("remindersPage");

        List<Reminder> reminderList = reminderService.findReminderByUser(userService.findUserByUserId(1));
        mav.addObject("reminderList", reminderList);
        mav.addObject("reminderListForm", new ReminderListForm());


/*        List<Reminder> selectedReminderList = reminderListForm.getReminderList();
        model.addAttribute("resultList",selectedReminderList);*/

    /*    for (Reminder reminder : selectedReminderList) {
            reminderService.deleteReminderById(reminder.getReminderId());
        }*/
/*
        if (resul.hasErrors()) {
            return "remindersPage";
        }*/

        return mav;
    }

    @RequestMapping(value = "/sent-list"/*, method = RequestMethod.GET*/)
    public ModelAndView save(/*@PathVariable Integer id,*/ @ModelAttribute("reminderListForm") ReminderListForm reminderListForm) {

        ModelAndView mav = new ModelAndView("sent-list");
        mav.addObject("reminderListForm", reminderListForm);
      /*  for(Reminder reminder : reminderListForm.getReminderList()){
            //make some computation here
        }*/
        return mav;
    }
}
