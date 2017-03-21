package com.inspoweb.utils.schedule;

import com.inspoDataBase.entity.Reminder;
import com.inspoDataBase.entity.User;
import com.inspoDataBase.jpaUsageDataBase.service.ReminderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * @author mmikilchenko on 15.03.2017.
 */
public class ReminderTimer {
    private User user;
    private ReminderService reminderService;
    private int appearingDelay;


    @Autowired
    public ReminderTimer(User user, ReminderService reminderService, int appearingDelay) {
        this.user = user;
        this.reminderService = reminderService;
        this.appearingDelay = appearingDelay;
    }

    public void run() throws InterruptedException {

        List<Reminder> remindersList = reminderService.findReminderByUser(user);
        Thread userNotificationThread = getThreadByName((user.getUserName()));

        if (userNotificationThread != null) {
            userNotificationThread.interrupt();
        }

        Timer timer = new Timer(user.getUserName(), true);

        for (Reminder reminder : remindersList) {
            TimerTask task = new ReminderTimerTask(reminder);
            timer.schedule(task, 0 /*360000*/);
            userNotificationThread.sleep(10000/*TimeUnit.MINUTES.toMillis(appearingDelay)*/);
        }

    }

    private Thread getThreadByName(String threadName) {
        for (Thread t : Thread.getAllStackTraces().keySet()) {
            if (t.getName().equals(threadName)) return t;
        }
        return null;
    }
}
