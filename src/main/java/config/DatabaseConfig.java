/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author user
 */
public class DatabaseConfig {
    private static final Logger logger = LoggerFactory.getLogger(DatabaseConfig.class);
    
    private static final String URL = "jdbc:mysql://localhost:8889/sales_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    
    private static Connection connection = null;
    
    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                logger.info("Database connection established successfully");
            }
            return connection;
        } catch (ClassNotFoundException e) {
            logger.error("MySQL JDBC Driver not found", e);
            throw new RuntimeException("MySQL JDBC Driver not found", e);
        } catch (SQLException e) {
            logger.error("Database connection failed", e);
            throw new RuntimeException("Database connection failed", e);
        }
    }
    
    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                logger.info("Database connection closed successfully");
            }
        } catch (SQLException e) {
            logger.error("Error closing database connection", e);
        }
    }
}
