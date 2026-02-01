package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.logging.Logger;

public class UserService {

    Logger logger = Logger.getLogger(UserService.class.getName());

    // Read password from environment variable or system property
    private String password = System.getenv("DB_PASSWORD") != null 
        ? System.getenv("DB_PASSWORD") 
        : System.getProperty("db.password");

    // FIXED: Using PreparedStatement to prevent SQL Injection
    public void findUser(String username) {
        String query =
            "SELECT id, name, email FROM users WHERE name = ?";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/db",
                    "root", password);
             PreparedStatement st = conn.prepareStatement(query)) {

            st.setString(1, username);
            st.executeQuery();
        } catch (java.sql.SQLException e) {
            logger.severe("SQL Exception: " + e.getMessage());
            // Handle exception appropriately
        }
    }
}
