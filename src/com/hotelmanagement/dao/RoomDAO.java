package com.hotelmanagement.dao;

import com.hotelmanagement.FileManager.FileLogger;
import com.hotelmanagement.model.IRoom;
import com.hotelmanagement.model.Room;
import com.hotelmanagement.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomDAO {

//    private static final String URL = "jdbc:mysql://localhost:3306/hotelmanagementsystem";
//    private static final String USER = "root";
//    private static final String PASSWORD = "password";

    public boolean addRoom(String number, String type, double price) {
        String sql = "INSERT INTO rooms (number, type, price) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, number);
            stmt.setString(2, type);
            stmt.setDouble(3, price);

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            FileLogger.writeSevereLog(e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public IRoom getRoom(int id) {
        String sql = "SELECT * FROM rooms WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Room(rs.getInt("id"), rs.getString("number"), rs.getString("type"), rs.getDouble("price"));
            }
        } catch (SQLException e) {
            FileLogger.writeSevereLog(e.getMessage());
            e.printStackTrace();
        }

        return null;
    }

    public List<IRoom> getAllRooms() {
        String sql = "SELECT * FROM rooms";
        List<IRoom> rooms = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                rooms.add(new Room(rs.getInt("id"), rs.getString("number"), rs.getString("type"), rs.getDouble("price")));
            }
        } catch (SQLException e) {
            FileLogger.writeSevereLog(e.getMessage());
            e.printStackTrace();
        }

        return rooms;
    }

    public boolean updateRoom(int id, String number, String type, double price) {
        String sql = "UPDATE rooms SET number = ?, type = ?, price = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, number);
            stmt.setString(2, type);
            stmt.setDouble(3, price);
            stmt.setInt(4, id);

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            FileLogger.writeSevereLog(e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteRoom(int id) {
        String sql = "DELETE FROM rooms WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            FileLogger.writeSevereLog(e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}

