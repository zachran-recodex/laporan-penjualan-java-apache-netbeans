/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import config.DatabaseConfig;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public class DatabaseConnectionTest {
    public static void main(String[] args) {
        try {
            Connection conn = DatabaseConfig.getConnection();
            System.out.println("Database connection test successful!");
            
            // Test query
            boolean valid = conn.isValid(5);
            System.out.println("Connection is valid: " + valid);
            
            DatabaseConfig.closeConnection();
        } catch (SQLException e) {
            System.err.println("Database connection test failed!");
        }
    }
}
