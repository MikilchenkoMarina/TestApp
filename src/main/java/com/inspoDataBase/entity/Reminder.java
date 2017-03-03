package com.inspoDataBase.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;

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
    @NotEmpty( message = "{NotEmpty.reminder.text}  ")
    private String text;

    @Basic
    @Column(name = "THEME_ID", length = 45)
    @NotEmpty( message = "{NotEmpty.reminder.theme}  ")
    private String themeId;

    public Reminder() {
    }

    public Reminder(String text, String themeId, User user) {
        this.text = text;
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

    public String getText() {
        return text;
    }

    public void setText(String reminderText) {
        this.text = reminderText;
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
                ", reminderText='" + text + '\'' +
                ", themeId='" + themeId + '\'' +
                '}';
    }
}
