package com.example.assignment1;

public class User {

    String username, password;

    public User(String u, String p) {
        this.setUsername(u);
        this.setPassword(p);
    }

    public User() {
        this.setUsername("test1234");
        this.setPassword("test1234");
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
