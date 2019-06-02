package com.startopole.model.viewModel;

import java.util.List;

public class PanelFencerViewModel {

    private String username;
    private String name;
    private String surname;
    private String email;
    private String bir_date;
    private String phone;
    private String category;
    private List<String> usernameList;

    public PanelFencerViewModel() {
    }

    public PanelFencerViewModel(String username, String name, String surname, String email, String bir_date, String phone, String category) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.bir_date = bir_date;
        this.phone = phone;
        this.category = category;
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

    public List<String> getUsernameList() {
        return usernameList;
    }

    public void setUsernameList(List<String> usernameList) {
        this.usernameList = usernameList;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
