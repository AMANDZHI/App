package com.company.api;

import com.company.model.User;

public interface UserRepository extends Repository<User> {
    User findByLogin(String login);
}