package com.inspoweb.utils.schedule;

import com.inspoDataBase.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Timer;
import java.util.TimerTask;


/**
 * @author mmikilchenko on 15.03.2017.
 */
public class ReminderTimer {
    private User user;


    @Autowired
    public ReminderTimer(User user) {
        this.user = user;
    }

    public void run() {
        TimerTask task = new ReminderTimerTask(user);

        Timer timer = new Timer();
        timer.schedule(task, 10000, 600000);
    }
}
