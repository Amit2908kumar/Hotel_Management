package com.hotelmanagement.controller;

import com.hotelmanagement.model.IUser;
import com.hotelmanagement.model.User;
import com.hotelmanagement.service.IUserService;
import com.hotelmanagement.service.UserServiceImpl;

public class UserControllerImpl implements IUserController {
    private IUserService userService;

    public UserControllerImpl() {
        this.userService = new UserServiceImpl();
    }

    @Override
    public boolean register(String username, String password, String role) {
        IUser user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setRole(role);
        return userService.registerUser(user);
    }

    @Override
    public IUser login(String username, String password) {
        return userService.loginUser(username, password);
    }
}
