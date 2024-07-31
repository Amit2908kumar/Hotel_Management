package com.hotelmanagement.service;

import com.hotelmanagement.dao.IUserDAO;
import com.hotelmanagement.dao.UserDAOImpl;
import com.hotelmanagement.model.IUser;

public class UserServiceImpl implements IUserService {
    private IUserDAO userDAO;

    public UserServiceImpl() {
        this.userDAO = new UserDAOImpl();
    }

    @Override
    public boolean registerUser(IUser user) {
        return userDAO.createUser(user);
    }

    @Override
    public IUser loginUser(String username, String password) {
        return userDAO.login(username, password);
    }
}
