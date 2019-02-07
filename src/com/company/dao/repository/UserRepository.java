package com.company.dao.repository;

import com.company.model.User;

public interface UserRepository extends Repository<User> {
    User findByLogin(String login);
}