package com.petrov.patterns.orm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseService {
    static Statement statement;
    static Connection connection;

    public static void connect() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/users?serverTimezone=UTC", "root", "13barsik!Z");
            statement = connection.createStatement();
            System.out.println("Connected with database");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void disconnect() {
        try {
            statement.close();
            System.out.println("Disconnected with database");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
