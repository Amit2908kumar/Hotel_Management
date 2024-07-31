package com.hotelmanagement.model;

public interface IUser {
    int getId();
    void setId(int id);
    String getUsername();
    void setUsername(String username);
    String getPassword();
    void setPassword(String password);
    String getRole();
    void setRole(String role);
}
