package com.company.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionSupplier {
    private String url_db;
    private String login_db;
    private String password_db;

    public Connection getConnection() throws SQLException {
        try {
            Properties property = new Properties();
            FileInputStream fis = new FileInputStream("src/resources/config.properties");
            property.load(fis);
            url_db = property.getProperty("db.host");
            login_db = property.getProperty("db.login");
            password_db = property.getProperty("db.password");
            Connection connection = DriverManager.getConnection(url_db, login_db, password_db);
            return connection;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}