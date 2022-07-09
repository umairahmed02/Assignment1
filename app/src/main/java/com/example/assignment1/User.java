package com.example.assignment1;

public class User {

    String username, password, email;

    private static User userInstance = null;

    public User(String u, String p, String e) {
        this.setUsername(u);
        this.setPassword(p);
        this.setEmail(e);
    }

    public User() {
        this.setUsername("test1234");
        this.setPassword("test1234");
        this.setEmail("test@gmail.com");

    }

    public static User getInstance(String u, String p, String e) {
        if(userInstance == null) {
            userInstance = new User(u, p, e);
        }
        return userInstance;
    }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

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
