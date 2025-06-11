package com.example.model;
public class User {
    private String userId;
    private String name;
    private String phone;
    private String location;
    private String password; // In real apps, you'd hash it

    public User() {
    }

    public User(String userId, String name, String phone, String location, String password) {
        this.userId = userId;
        this.name = name;
        this.phone = phone;
        this.location = location;
        this.password = password;
    }

    // Getters and setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
