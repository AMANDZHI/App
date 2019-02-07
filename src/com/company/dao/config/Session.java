package com.company.dao.config;

import com.company.model.User;

public class Session {
    private User user;

    public void save(User object) {
        this.user = object;
    }

    public User getUser() {
        return user;
    }

    public void invalidate() {
        user = null;
    }
}
