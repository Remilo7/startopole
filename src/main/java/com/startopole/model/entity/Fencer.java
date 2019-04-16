package com.startopole.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FENCERS")
public class Fencer {

    @Id

    @Column
    private String userName;

    @Column
    private String email;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String bir_date;

    @Column
    private String phone;

    public Fencer(){ }

    public Fencer(String userName, String email, String name, String surname, String bir_date, String phone) {
        this.userName = userName;
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.bir_date = bir_date;
        this.phone = phone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getBir_date() {
        return bir_date;
    }

    public void setBir_date(String bir_date) {
        this.bir_date = bir_date;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
