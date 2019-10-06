package com.example.analysis_journal.entity;

public class User {

    private int id;
    private String name;
    private String password;
    private String email;
    private Sex sex;

    public User() {

    }

    public User(String name, String email, String password, Sex sex) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
