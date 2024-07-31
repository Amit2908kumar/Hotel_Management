package com.hotelmanagement.service;

import com.hotelmanagement.model.ICustomer;

import java.util.List;

public interface ICustomerService {
    boolean addCustomer(ICustomer customer);
    ICustomer getCustomer(int id);
    List<ICustomer> getAllCustomers();
    boolean updateCustomer(ICustomer customer);
    boolean deleteCustomer(int id);
}
