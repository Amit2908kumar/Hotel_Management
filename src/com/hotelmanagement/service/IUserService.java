package com.hotelmanagement.service;

import com.hotelmanagement.model.IUser;

public interface IUserService {
    boolean registerUser(IUser user);
    IUser loginUser(String username, String password);
}
