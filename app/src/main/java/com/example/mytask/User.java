package com.example.mytask;

import java.io.Serializable;

public class User implements Serializable
{
    private String  firstname;
    private String secondname;
    private String email;
    private String password;
    private String dob;

    public User()
    {

    }


    public User(String firstname, String secondname, String email, String password, String dob) {
        this.firstname = firstname;
        this.secondname = secondname;
        this.email = email;
        this.password = password;
        this.dob = dob;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
}
