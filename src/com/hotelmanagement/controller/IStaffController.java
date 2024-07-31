// IStaffController.java
package com.hotelmanagement.controller;

import com.hotelmanagement.model.IStaff;
import java.util.List;

public interface IStaffController {
    boolean addStaff(String name, String position, double salary);
    IStaff getStaff(int id);
    List<IStaff> getAllStaff();
    boolean updateStaff(int id, String name, String position, double salary);
    boolean deleteStaff(int id);
}
