package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UserService {

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
            e.printStackTrace();
            // Handle exception appropriately
        }
    }
}
