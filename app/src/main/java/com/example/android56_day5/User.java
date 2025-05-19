package com.example.android56_day5;

public class User {
    private String userName;
    private String avatar;

    private String phoneNumber;

    public User(String phoneNumber, String avatar, String userName) {
        this.phoneNumber = phoneNumber;
        this.avatar = avatar;
        this.userName = userName;
    }

    public User() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    @Override
    public String toString() {
        return "User{" + "userName='" + userName + '\'' + ", avatar='" + avatar + '\'' + ", phoneNumber='" + phoneNumber + '\'' + '}';
    }
}
