package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.logging.Logger;

public class UserService {

    Logger logger = Logger.getLogger(UserService.class.getName());

    // SECURITY ISSUE: Hardcoded credentials
    private String password = "admin123";

    // VULNERABILITY: SQL Injection
    public void findUser(String username) {
        String query =
            "SELECT * FROM users WHERE name = '" + username + "'";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/db",
                    "root", password);
             Statement st = conn.createStatement()) {

            st.executeQuery(query);
        } catch (java.sql.SQLException e) {
            logger.severe("SQL Exception: " + e.getMessage());
            // Handle exception appropriately
        }
    }
}
