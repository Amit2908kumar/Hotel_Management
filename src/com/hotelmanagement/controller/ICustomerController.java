package com.hotelmanagement.controller;

import com.hotelmanagement.model.ICustomer;

import java.util.List;

public interface ICustomerController {
    boolean addCustomer(String name, String email);
    ICustomer getCustomer(int id);
    List<ICustomer> getAllCustomers();
    boolean updateCustomer(int id, String name, String email);
    boolean deleteCustomer(int id);
}
