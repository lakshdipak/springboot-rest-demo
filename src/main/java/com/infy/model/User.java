package com.infy.model;


public class User {

    private Integer userId;
    private String age;
    private String gender;
    private String fName;
    private String lName;

    public User() {


    }

    public User(Integer userId, String age, String gender, String fName, String lName) {
        super();
        this.userId = userId;
        this.age = age;
        this.gender = gender;
        this.fName = fName;
        this.lName = lName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }


}
