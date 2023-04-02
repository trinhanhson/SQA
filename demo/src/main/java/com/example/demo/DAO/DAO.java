/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ADMIN
 */
public class DAO {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/sqa";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "201201";

    private Connection conn;

    // Constructor to initialize the database connection
    public DAO() throws ClassNotFoundException, SQLException {
        // Load the MySQL JDBC driver
        Class.forName("com.mysql.jdbc.Driver");

        // Create the database connection
        conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    // Method to get the JDBC connection object
    public Connection getConnection() {
        return conn;
    }

    // Method to close the JDBC connection object
    public void closeConnection() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }
}
