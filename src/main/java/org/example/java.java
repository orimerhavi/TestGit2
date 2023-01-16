package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java {
    void openConnection()
    {
        String jdbcURL = "jdbc:postgresql://localhost:5432/LearnGit";
        String userName = "postgres";
        String password = "oriori10";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(jdbcURL, userName, password);
            System.out.print("There is connection");
        } catch (SQLException e) {
            System.out.print("No Connection");
            throw new RuntimeException(e);
        }

        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
