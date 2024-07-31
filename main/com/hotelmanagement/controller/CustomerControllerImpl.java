package com.hotelmanagement.controller;

import com.hotelmanagement.model.ICustomer;
import com.hotelmanagement.model.Customer;
import com.hotelmanagement.service.ICustomerService;
import com.hotelmanagement.service.CustomerServiceImpl;

import java.util.List;

public class CustomerControllerImpl implements ICustomerController {
    private ICustomerService customerService;

    public CustomerControllerImpl() {
        this.customerService = new CustomerServiceImpl();
    }

    @Override
    public boolean addCustomer(String name, String email) {
        ICustomer customer = new Customer();
        customer.setName(name);
        customer.setEmail(email);
        return customerService.addCustomer(customer);
    }

    @Override
    public ICustomer getCustomer(int id) {
        return customerService.getCustomer(id);
    }

    @Override
    public List<ICustomer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @Override
    public boolean updateCustomer(int id, String name, String email) {
        ICustomer customer = new Customer();
        customer.setId(id);
        customer.setName(name);
        customer.setEmail(email);
        return customerService.updateCustomer(customer);
    }

    @Override
    public boolean deleteCustomer(int id) {
        return customerService.deleteCustomer(id);
    }
}
