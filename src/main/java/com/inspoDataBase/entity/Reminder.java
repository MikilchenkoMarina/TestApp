package com.inspoDataBase.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

/**
 * Created by mmikilchenko on 15.02.2017.
 */
@Entity
@Table(name = "public.reminder"/*, schema = "inspominder", catalog = ""*/)
public class Reminder {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int reminderId;

    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Basic
    @Column(name = "text", length = 200)
    @NotEmpty( message = "{NotEmpty.reminder.text}  ")
    private String text;

    @Basic
    @Column(name = "imagelink", length = 200)
    private String imageLink;

    public Reminder() {
    }

    public Reminder(String text, String imageLink, User user) {
        this.text = text;
        this.imageLink = imageLink;
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

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String themeId) {
        this.imageLink = themeId;
    }


    @Override
    public String toString() {
        return "Reminder{" +
                "reminderId=" + reminderId +
                ", reminderText='" + text + '\'' +
                ", imageLink='" + imageLink + '\'' +
                '}';
    }
}
