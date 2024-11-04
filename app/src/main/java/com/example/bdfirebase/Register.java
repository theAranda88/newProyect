package com.example.bdfirebase;

import androidx.annotation.NonNull;

public class Register {
    private String user;
    private String pass;

    public Register() {
    }

    public Register(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }
}
