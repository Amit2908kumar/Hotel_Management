package com.hotelmanagement.controller;

import com.hotelmanagement.model.IUser;

public interface IUserController {
    boolean register(String username, String password, String role);
    IUser login(String username, String password);
}
