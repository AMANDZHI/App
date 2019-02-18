package com.company.dao;

import lombok.SneakyThrows;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.FileInputStream;
import java.io.Reader;
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

    @SneakyThrows
    public SqlSession getSession() {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();
       return session;
    }
}