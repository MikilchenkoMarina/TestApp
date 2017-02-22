package inspoDataBase.jpaUsageDataBase.app;


import inspoDataBase.entity.Reminder;
import inspoDataBase.entity.User;
import inspoDataBase.jpaUsageDataBase.JpaSpringConfigs;
import inspoDataBase.jpaUsageDataBase.service.ReminderService;
import inspoDataBase.jpaUsageDataBase.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Created by mmikilchenko on 21.02.2017.
 */
public class StandaloneJpaDbAppTest {


    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(JpaSpringConfigs.class);

        ReminderService reminderService = (ReminderService) context.getBean("reminderService");
        UserService userService = (UserService) context.getBean("userService");

        User testUser = new User(1, "Billy Jonson", "pass", null);
        Reminder remFirst = new Reminder(1, "The only source of knowledge is experience.", "Albert Einstein Quotes", testUser);
        Reminder remSecond = new Reminder(2, "Never do anything against conscience even if the state demands it.", "Albert Einstein Quotes", testUser);

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
        System.out.println(String.format("User by id %s search result : %s", 1, byUserIdUser.toString()));

        userService.deleteUserById(1);


    }


}
