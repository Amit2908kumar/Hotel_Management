
package com.hotelmanagement.controller;

import com.hotelmanagement.model.IRoom;
import java.util.List;

public interface IRoomController {
    boolean addRoom(String number, String type, double price);
    IRoom getRoom(int id);
    List<IRoom> getAllRooms();
    boolean updateRoom(int id, String number, String type, double price);
    boolean deleteRoom(int id);
}

