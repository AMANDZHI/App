package com.company.model;

import com.company.util.Encryption;

import java.util.UUID;

public class User {
    private String id;
    private String name;
    private String login;
    private String password;
    private boolean admin;

    public User(String login, String password) {
        this.login = login;
        this.password = Encryption.md5Custom(password);
    }

    public User(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = Encryption.md5Custom(password);
        this.id = UUID.randomUUID().toString();
    }

    public User(String name, String login, String password, boolean admin) {
        this.name = name;
        this.login = login;
        this.password = Encryption.md5Custom(password);
        this.admin = admin;
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", admin=" + admin +
                '}';
    }
}