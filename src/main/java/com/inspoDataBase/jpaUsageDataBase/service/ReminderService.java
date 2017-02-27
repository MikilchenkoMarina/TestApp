package com.inspoDataBase.jpaUsageDataBase.service;

import com.inspoDataBase.entity.Reminder;
import com.inspoDataBase.entity.User;
import com.inspoDataBase.jpaUsageDataBase.jpaRepository.ReminderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by mmikilchenko on 21.02.2017.
 */
@Service("reminderService")
@Transactional
public class ReminderService {
    @Autowired
    ReminderRepository reminderRepository;

    public void addReminder(Reminder reminder, User user) {
        reminder.setUser(user);
        reminderRepository.saveAndFlush(reminder);
    }

    public List<Reminder> findReminderByText(String text) {
        return reminderRepository.findByReminderText(text);
    }

    public List<Reminder> findReminderAll() {
        return reminderRepository.findAll();
    }

    public List<Reminder> findReminderByUser(User user) {
        return reminderRepository.findByUser(user);
    }

    public List<Reminder> findReminderByUserAndText(User user, String reminderText) {
        return reminderRepository.findByUserAndReminderText(user, reminderText);
    }

    public void printReminders(List<Reminder> reminderList) {
        for (Reminder reminder : reminderList) {
            System.out.println(reminder.toString());
        }
    }

    public void deleteReminderById(int reminderId) {
        reminderRepository.deleteByReminderId(reminderId);
    }

}
