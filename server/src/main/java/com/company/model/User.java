package com.company.model;

import com.company.util.Encryption;
import com.company.util.UserRole;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@ToString
public class User implements Serializable {
    private String id;
    private String name;
    private String login;
    private String password;
    private UserRole role;

    public User() {
        this.role = UserRole.USER;
        this.id = UUID.randomUUID().toString();
    }

    public User(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = Encryption.md5Custom(password);
        this.id = UUID.randomUUID().toString();
        this.role = UserRole.USER;
    }

    public User(String name, String login, String password, UserRole role) {
        this.name = name;
        this.login = login;
        this.password = Encryption.md5Custom(password);
        this.role = role;
        this.id = UUID.randomUUID().toString();
    }

    public void setPassword(String password) {
        this.password = password;
    }
}