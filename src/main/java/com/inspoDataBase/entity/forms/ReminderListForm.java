package com.inspoDataBase.entity.forms;

import com.inspoDataBase.entity.Reminder;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author mmikilchenko on 06.03.2017.
 */
@Component("reminderListForm")
public class ReminderListForm {
    private List<Reminder> reminderList;

    public List<Reminder> getReminderList() {
        return reminderList;
    }

    public void setReminderList(List<Reminder> reminderList) {
        this.reminderList = reminderList;
    }
}
