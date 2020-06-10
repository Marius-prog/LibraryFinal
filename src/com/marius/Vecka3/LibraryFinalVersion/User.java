package com.marius.Vecka3.LibraryFinalVersion;

import java.io.Serializable;


public class User extends LibraryItem implements Serializable {

    //private static final long serialversionUID = 129348938L;

    private String name;
    private int mobileNumber;


    public User(String name, int userId, int mobileNumber) {
        this.name = name;
        super.setId(userId);
        this.mobileNumber = mobileNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserId() {
        return super.getId();
    }

    public void setUserId(int userId) {
        super.setId(userId);
    }

    public int getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(int mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Override
    public String toString() {
        return "user - " + name + ", user Id - " + super.getId() + ", mobil telefon number - " + mobileNumber;
    }
}

