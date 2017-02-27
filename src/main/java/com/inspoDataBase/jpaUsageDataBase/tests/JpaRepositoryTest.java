package com.inspoDataBase.jpaUsageDataBase.tests;

import com.inspoDataBase.entity.Reminder;
import com.inspoDataBase.entity.User;
import com.inspoDataBase.jpaUsageDataBase.JpaSpringConfigs;
import com.inspoDataBase.jpaUsageDataBase.jpaRepository.ReminderRepository;
import com.inspoDataBase.jpaUsageDataBase.jpaRepository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertNotNull;

/**
 * Created by mmikilchenko on 21.02.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JpaSpringConfigs.class})
@Transactional
public class JpaRepositoryTest {
    @Autowired
    ReminderRepository reminderRepository;
    @Autowired
    UserRepository userRepository;
    private static Logger logger = LoggerFactory.getLogger(JpaRepositoryTest.class);

    @Test
    public void start() {

        User testUser = new User("Marina", "Mikilchenko", "mikimar", "pass", null);
        userRepository.saveAndFlush(testUser);
        Reminder newReminder = new Reminder( "Test Jpa Reminder. ", "Test Quotes", testUser);

        reminderRepository.saveAndFlush(newReminder);
        assertNotNull(reminderRepository);
        assertNotNull(userRepository);

    }
}
