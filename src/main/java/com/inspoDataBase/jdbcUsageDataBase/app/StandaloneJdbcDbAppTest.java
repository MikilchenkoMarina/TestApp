package com.inspoDataBase.jdbcUsageDataBase.app;


import com.inspoDataBase.jdbcUsageDataBase.dao.ReminderDao;
import com.inspoDataBase.jdbcUsageDataBase.dao.UserDao;
import com.inspoDataBase.jdbcUsageDataBase.entity.ReminderEntity;
import com.inspoDataBase.jdbcUsageDataBase.entity.UserEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by mmikilchenko on 09.02.2017.
 */
public class StandaloneJdbcDbAppTest {
    public static void main(String[] args) {


        ApplicationContext context = new ClassPathXmlApplicationContext("InspoMinderDataBaseConfig.xml");
        UserDao userDao = (UserDao) context.getBean("jdbcUserDao");
        ReminderDao reminderDao = (ReminderDao) context.getBean("jdbcReminderDao");

        // Add User
        UserEntity userMarina = new UserEntity(5, "TestJdbcUser", "pass");
        userDao.addUser(userMarina);

        // Add Reminder
        ReminderEntity testReminder = new ReminderEntity(7, "Life is good!", "Theme 1", 5);
        reminderDao.addReminder(testReminder);

        // Get Reminder
        System.out.println(reminderDao.getReminderById(7));
        ;

        // Show all users User
        List<UserEntity> allUsersList = userDao.getAllUsers();
        System.out.println(" Users List : ");
        for (UserEntity user : allUsersList) {
            System.out.println(user.toString());
        }
        //  Select by Id User
        System.out.println(userDao.getUserById(5));

        //  Delete User
        // userDao.deleteByUserId(5);

    }
}
