package com.company.model;

import com.company.util.Encryption;
import com.company.util.UserRole;

import java.io.Serializable;
import java.util.UUID;

public class User implements Serializable {
    private String id;
    private String name;
    private String login;
    private String password;
    private UserRole role;

    public User() {
    }

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

    public User(String name, String login, String password, UserRole role) {
        this.name = name;
        this.login = login;
        this.password = Encryption.md5Custom(password);
        this.role = role;
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return this.login;
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

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}