package com.startopole.model.viewModel;

public class RegistrationViewModel {

    private String userName;
    private String password;
    private String email;
    private String name;
    private String surname;
    private String bir_date;
    private String phone;

    public RegistrationViewModel() {
    }

    public RegistrationViewModel(String userName, String password, String email, String name, String surname, String bir_date, String phone) {
        this.userName = userName;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
