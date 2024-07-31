package com.hotelmanagement.dao;

import com.hotelmanagement.model.IUser;

public interface IUserDAO {
    boolean createUser(IUser user);
    IUser login(String username, String password);
}
