package com.company.model;

import com.company.util.Encryption;
import com.company.util.UserRole;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name="user_tbl")
@Getter
@Setter
public class User implements Serializable {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "login", nullable = false, unique = true)
    private String login;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
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