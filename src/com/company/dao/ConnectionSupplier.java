package com.company.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSupplier {
    private final String URL_DB = "jdbc:mysql://localhost:3306/todoList";
    private final String LOGIN_DB = "root";
    private final String PASSWORD_DB = "root";

    public Connection getConnection() throws SQLException {
            Connection connection = DriverManager.getConnection(URL_DB, LOGIN_DB, PASSWORD_DB);
            return connection;
    }
}
