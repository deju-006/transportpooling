package com.example.miniproject1234;

public class User {

    public String  dob,gender,phone,region,username;

    public User() {
    }

    public User(String gender,  String phone, String region,String dob,String username) {
        this.gender = gender;

        this.phone = phone;
        this.region = region;
        this.dob=dob;
        this.username=username;

    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
