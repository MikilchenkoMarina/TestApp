package com.inspoweb.utils.schedule;

import com.inspoDataBase.entity.Reminder;
import com.inspoDataBase.entity.User;
import com.inspoDataBase.jpaUsageDataBase.service.ReminderService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import java.util.List;
import java.util.TimerTask;

/**
 * @author mmikilchenko on 15.03.2017.
 */
public class ReminderTimerTask extends TimerTask {
    @Autowired
    private ReminderService reminderService;
    private User user;


    @Autowired
    public ReminderTimerTask(User user) {
        this.user = user;
    }


    @Override
    public void run() {

        List<Reminder> userReminders = reminderService.findReminderByUser(user);

        for (Reminder reminder : userReminders) {
            showReminderMessage(reminder);

        }

    }

    public void showReminderMessage(Reminder reminder) {

        JOptionPane pane = new JOptionPane();
        pane.requestFocusInWindow();
        pane.requestFocus();

        final JDialog d = pane.createDialog((JFrame) null, reminder.getText());
        d.requestFocusInWindow();
        d.setFocusable(true);
        d.setLocation(20, 20);
        d.setSize(200, 200);
        d.setVisible(true);

    }


}
