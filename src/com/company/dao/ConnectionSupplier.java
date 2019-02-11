package com.company.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSupplier {
    private final static String URL_DB = "jdbc:mysql://localhost:3306/todoList";
    private final static String LOGIN_DB = "root";
    private final static String PASSWORD_DB = "root";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL_DB, LOGIN_DB, PASSWORD_DB);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
