package com.hotelmanagement.dao;

import com.hotelmanagement.FileManager.FileLogger;
import com.hotelmanagement.model.IStaff;
import com.hotelmanagement.model.Staff;
import com.hotelmanagement.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StaffDAO {

//    private static final String URL = "jdbc:mysql://localhost:3306/hotelmanagementsytem";
//    private static final String USER = "root";
//    private static final String PASSWORD = "password";

    public boolean addStaff(String name, String position, double salary) {
        String sql = "INSERT INTO staff (name, position, salary) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            stmt.setString(2, position);
            stmt.setDouble(3, salary);

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            FileLogger.writeSevereLog(e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public IStaff getStaff(int id) {
        String sql = "SELECT * FROM staff WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Staff(rs.getInt("id"), rs.getString("name"), rs.getString("position"), rs.getDouble("salary"));
            }
        } catch (SQLException e) {
            FileLogger.writeSevereLog(e.getMessage());
            e.printStackTrace();
        }

        return null;
    }

    public List<IStaff> getAllStaff() {
        String sql = "SELECT * FROM staff";
        List<IStaff> staff = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                staff.add(new Staff(rs.getInt("id"), rs.getString("name"), rs.getString("position"), rs.getDouble("salary")));
            }
        } catch (SQLException e) {
            FileLogger.writeSevereLog(e.getMessage());
            e.printStackTrace();
        }

        return staff;
    }

    public boolean updateStaff(int id, String name, String position, double salary) {
        String sql = "UPDATE staff SET name = ?, position = ?, salary = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            stmt.setString(2, position);
            stmt.setDouble(3, salary);
            stmt.setInt(4, id);

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            FileLogger.writeSevereLog(e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteStaff(int id) {
        String sql = "DELETE FROM staff WHERE id = ?";

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
