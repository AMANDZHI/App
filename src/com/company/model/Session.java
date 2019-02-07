package com.company.model;

import com.company.model.User;

public class Session {
    private User user;

    public Session() {
    }

    public Session(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
