package com.hotelmanagement.dao;

import com.hotelmanagement.FileManager.FileLogger;
import com.hotelmanagement.model.Customer;
import com.hotelmanagement.model.ICustomer;
import com.hotelmanagement.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements ICustomerDAO {

    @Override
    public boolean createCustomer(ICustomer customer) {
        String sql = "INSERT INTO customers (name, email) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, customer.getName());
            pstmt.setString(2, customer.getEmail());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            FileLogger.writeSevereLog(e.getMessage());
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public ICustomer getCustomerById(int id) {
        String sql = "SELECT * FROM customers WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                ICustomer customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setName(rs.getString("name"));
                customer.setEmail(rs.getString("email"));
                return customer;
            }
        } catch (SQLException e) {
            FileLogger.writeSevereLog(e.getMessage());
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<ICustomer> getAllCustomers() {
        String sql = "SELECT * FROM customers";
        List<ICustomer> customers = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                ICustomer customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setName(rs.getString("name"));
                customer.setEmail(rs.getString("email"));
                customers.add(customer);
            }
        } catch (SQLException e) {
            FileLogger.writeSevereLog(e.getMessage());
            System.out.println(e.getMessage());
        }
        return customers;
    }

    @Override
    public boolean updateCustomer(ICustomer customer) {
        String sql = "UPDATE customers SET name = ?, email = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, customer.getName());
            pstmt.setString(2, customer.getEmail());
            pstmt.setInt(3, customer.getId());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            FileLogger.writeSevereLog(e.getMessage());
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteCustomer(int id) {
        String sql = "DELETE FROM customers WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            FileLogger.writeSevereLog(e.getMessage());
            System.out.println(e.getMessage());
            return false;
        }
    }
}
