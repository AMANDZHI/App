package com.company.service;

import com.company.model.User;

public interface UserService extends Service<User> {
    User findByLogin(String login);
}
