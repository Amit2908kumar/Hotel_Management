package com.hotelmanagement.dao;

import com.hotelmanagement.model.ICustomer;

import java.util.List;

public interface ICustomerDAO {
    boolean createCustomer(ICustomer customer);
    ICustomer getCustomerById(int id);
    List<ICustomer> getAllCustomers();
    boolean updateCustomer(ICustomer customer);
    boolean deleteCustomer(int id);
}
