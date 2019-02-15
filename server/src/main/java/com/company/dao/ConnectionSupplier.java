package com.company.dao;

import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionSupplier {
    private String url_db;
    private String login_db;
    private String password_db;

    @SneakyThrows
    public Connection getConnection() {
        Properties property = new Properties();
        FileInputStream fis = new FileInputStream("server/src/main/resources/config.properties");
        property.load(fis);
        url_db = property.getProperty("db.host");
        login_db = property.getProperty("db.login");
        password_db = property.getProperty("db.password");
        return DriverManager.getConnection(url_db, login_db, password_db);
    }
}