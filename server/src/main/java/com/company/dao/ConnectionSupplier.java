package com.company.dao;

import com.company.model.Project;
import com.company.model.Task;
import com.company.model.User;
import lombok.SneakyThrows;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import javax.persistence.EntityManager;
import java.io.FileInputStream;
import java.util.Properties;

public class ConnectionSupplier {
    private String url_db;
    private String login_db;
    private String password_db;
    private String driver_db;
    private String dialect_db;
    private String hbm2ddl;
    private SessionFactory sessionFactory;

    {
        sessionFactory = getSessionFactory();
    }

    public EntityManager getEntityManager() {
        return sessionFactory.createEntityManager();
    }

    @SneakyThrows
    private SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();
            Properties property = new Properties();

            FileInputStream fis = new FileInputStream("server/src/main/resources/config.properties");
            property.load(fis);
            driver_db = property.getProperty("db.driver");
            url_db = property.getProperty("db.host");
            login_db = property.getProperty("db.login");
            password_db = property.getProperty("db.password");
            dialect_db = property.getProperty("hibernate.dialect");
            hbm2ddl = property.getProperty("hbm2ddl.auto");

            property.put(Environment.DRIVER, driver_db);
            property.put(Environment.URL, url_db);
            property.put(Environment.USER, login_db);
            property.put(Environment.PASS, password_db);
            property.put(Environment.DIALECT, dialect_db);
            property.put(Environment.HBM2DDL_AUTO, hbm2ddl);
            configuration.setProperties(property);
            configuration.addAnnotatedClass(User.class);
            configuration.addAnnotatedClass(Project.class);
            configuration.addAnnotatedClass(Task.class);
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }
        return sessionFactory;
    }
}