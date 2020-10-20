package com.user.jattana.Model;

public class User {
    private String fName;
    private String lName;
    private String email;
    private String userType;
    private String password;

    public User() {
    }

    public User(String fname, String lname, String email,String userType, String password) {
        this.fName = fname;
        this.lName = lname;
        this.email = email;
        this.password = password;
        this.userType=userType;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getFName() {
        return fName;
    }

    public String getLName() {
        return lName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setFName(String fname) {
        this.fName = fname;
    }

    public void setLName(String lname) {
        this.lName = lname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Person{" +
                "fname:'" + fName + '\'' +
                ", lname:'" + lName + '\'' +
                ", email:'" + email + '\'' +
                ", password:'" + password + '\'' +
                '}';
    }
}
