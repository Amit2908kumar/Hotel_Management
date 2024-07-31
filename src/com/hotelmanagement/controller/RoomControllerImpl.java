package com.hotelmanagement.controller;

import com.hotelmanagement.dao.RoomDAO;
import com.hotelmanagement.model.IRoom;
import com.hotelmanagement.model.Room;

import java.util.List;

public class RoomControllerImpl implements IRoomController {

    private RoomDAO roomDAO = new RoomDAO();

    @Override
    public boolean addRoom(String number, String type, double price) {
        return roomDAO.addRoom(number, type, price);
    }

    @Override
    public IRoom getRoom(int id) {
        return roomDAO.getRoom(id);
    }

    @Override
    public List<IRoom> getAllRooms() {
        return roomDAO.getAllRooms();
    }

    @Override
    public boolean updateRoom(int id, String number, String type, double price) {
        return roomDAO.updateRoom(id, number, type, price);
    }

    @Override
    public boolean deleteRoom(int id) {
        return roomDAO.deleteRoom(id);
    }
}
