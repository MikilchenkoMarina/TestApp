package com.inspoDataBase.entity;

import javax.persistence.*;

/**
 * Created by mmikilchenko on 15.02.2017.
 */
@Entity
@Table(name = "reminder"/*, schema = "inspominder", catalog = ""*/)
public class Reminder {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int reminderId;

    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    @Basic
    @Column(name = "TEXT", length = 200)
    private String reminderText;

    @Basic
    @Column(name = "THEME_ID", length = 45)
    private String themeId;

    public Reminder() {
    }

    public Reminder(String reminderText, String themeId, User user) {
        this.reminderText = reminderText;
        this.themeId = themeId;
        this.user = user;
    }

    public int getReminderId() {
        return reminderId;
    }

    public void setReminderId(int reminderId) {
        this.reminderId = reminderId;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getReminderText() {
        return reminderText;
    }

    public void setReminderText(String reminderText) {
        this.reminderText = reminderText;
    }

    public String getThemeId() {
        return themeId;
    }

    public void setThemeId(String themeId) {
        this.themeId = themeId;
    }


    @Override
    public String toString() {
        return "Reminder{" +
                "reminderId=" + reminderId +
                ", reminderText='" + reminderText + '\'' +
                ", themeId='" + themeId + '\'' +
                '}';
    }
}
