package com.inspoDataBase.jpaUsageDataBase.app;


import com.inspoDataBase.entity.Reminder;
import com.inspoDataBase.entity.User;
import com.inspoDataBase.jpaUsageDataBase.JpaSpringConfigs;
import com.inspoDataBase.jpaUsageDataBase.service.ReminderService;
import com.inspoDataBase.jpaUsageDataBase.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by mmikilchenko on 21.02.2017.
 */
public class StandaloneJpaDbAppTest {


    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(JpaSpringConfigs.class);

        ReminderService reminderService = (ReminderService) context.getBean("reminderService");
        UserService userService = (UserService) context.getBean("userService");

        User testUser = new User(/*1,*/ "Marina", "Mikilchenko", "postgres111", "pasrthths", null);
        Reminder remFirst = new Reminder("The only source of knowledge is experience.", "Albert Einstein Quotes", testUser);
        Reminder remSecond = new Reminder("Never do anything against conscience even if the state demands it.", "Albert Einstein Quotes", testUser);

        userService.addUser(testUser);
        reminderService.addReminder(remFirst, testUser);
        reminderService.addReminder(remSecond, testUser);

        List<Reminder> byTextListReminder = reminderService.findReminderByText("The only source of knowledge is experience.");
        reminderService.printReminders(byTextListReminder);

        List<Reminder> byUserListReminder = reminderService.findReminderByUser(testUser);
        reminderService.printReminders(byUserListReminder);

        List<Reminder> byUserAndTextListReminder = reminderService.findReminderByUserAndText(testUser, "The only source of knowledge is experience.");
        reminderService.printReminders(byUserAndTextListReminder);

        User byUserIdUser = userService.findUserByUserId(1);


        userService.deleteUserById(1);


    }


}
