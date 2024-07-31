package com.hotelmanagement.service;

import com.hotelmanagement.dao.ICustomerDAO;
import com.hotelmanagement.dao.CustomerDAOImpl;
import com.hotelmanagement.model.ICustomer;

import java.util.List;

public class CustomerServiceImpl implements ICustomerService {
    private ICustomerDAO customerDAO;

    public CustomerServiceImpl() {
        this.customerDAO = new CustomerDAOImpl();
    }

    @Override
    public boolean addCustomer(ICustomer customer) {
        return customerDAO.createCustomer(customer);
    }

    @Override
    public ICustomer getCustomer(int id) {
        return customerDAO.getCustomerById(id);
    }

    @Override
    public List<ICustomer> getAllCustomers() {
        return customerDAO.getAllCustomers();
    }

    @Override
    public boolean updateCustomer(ICustomer customer) {
        return customerDAO.updateCustomer(customer);
    }

    @Override
    public boolean deleteCustomer(int id) {
        return customerDAO.deleteCustomer(id);
    }
}
