package com.hotelmanagement.controller;

import com.hotelmanagement.dao.StaffDAO;
import com.hotelmanagement.model.IStaff;
import com.hotelmanagement.model.Staff;

import java.util.List;

public class StaffControllerImpl implements IStaffController {

    private StaffDAO staffDAO = new StaffDAO();

    @Override
    public boolean addStaff(String name, String position, double salary) {
        return staffDAO.addStaff(name, position, salary);
    }

    @Override
    public IStaff getStaff(int id) {
        return staffDAO.getStaff(id);
    }

    @Override
    public List<IStaff> getAllStaff() {
        return staffDAO.getAllStaff();
    }

    @Override
    public boolean updateStaff(int id, String name, String position, double salary) {
        return staffDAO.updateStaff(id, name, position, salary);
    }

    @Override
    public boolean deleteStaff(int id) {
        return staffDAO.deleteStaff(id);
    }
}
