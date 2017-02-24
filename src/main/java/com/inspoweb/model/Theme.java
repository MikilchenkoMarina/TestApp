package com.inspoweb.model;

import javax.persistence.*;

/**
 * Created by mmikilchenko on 24.02.2017.
 */
@Entity
@Table(name = "theme"/*, schema = "inspominder", catalog = ""*/)
public class Theme {

    @Id
    @Column(name = "id", nullable = false)
    private int id;


    @Basic
    @Column(name = "name", length = 45)
    private String name;


    public Theme() {
    }

    public Theme(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int reminderId) {
        this.id = reminderId;
    }


    public String getName() {
        return name;
    }

    public void setName(String reminderText) {
        this.name = reminderText;
    }

}
