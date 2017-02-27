package com.inspoDataBase.entity;

import javax.persistence.*;
import java.util.List;


/**
 * Created by mmikilchenko on 15.02.2017.
 */
@Entity
@Table(name = "user"/*, schema = "inspominder", catalog = ""*/)
public class User {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int userId;

    @Basic
    @Column(name = "FIRST_NAME", length = 45)
    private String firstName;

    @Basic
    @Column(name = "LAST_NAME", length = 45)
    private String lastName;

    @Basic
    @Column(name = "USERNAME", length = 45)
    private String userName;

    @Basic
    @Column(name = "PASSWORD", length = 45)
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @ElementCollection(targetClass = Reminder.class)
    private List<Reminder> reminders;

    public User() {
    }

    public User(/*int userId,*/ String firstName, String lastName, String userName, String password, List<Reminder> reminders) {
       // this.userId = userId;
        this.reminders = reminders;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String userPassword) {
        this.password = userPassword;
    }

    public List<Reminder> getReminders() {
        return this.reminders;
    }

    public void setReminder(List<Reminder> reminders) {
        this.reminders = reminders;
    }

    @Override
    public String toString() {
        return "User{" +
              ", userName='" + this.userName + '\'' +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setReminders(List<Reminder> reminders) {
        this.reminders = reminders;
    }
}
