package com.hotelmanagement.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // Update the URL, username, and password according to your MySQL configuration
    private static final String URL = "jdbc:mysql://localhost:3306/hotel_management";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    // Load MySQL JDBC Driver
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    public static void main(String... args) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            if(conn != null){
                System.out.println("Jai Mata Di");
            }
            else{
                System.out.println("Gayi bhes pani mein");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
