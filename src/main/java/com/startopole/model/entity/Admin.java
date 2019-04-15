package com.startopole.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "ADMINS")
public class Admin {

    @Id
    private String username;

    @Column
    private String name;

    @Column
    private String surname;

    public Admin(){}

    public Admin(String username, String name, String surname) {
        this.username = username;
        this.name = name;
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
