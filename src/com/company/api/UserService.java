package com.company.api;

import com.company.model.User;

import java.util.Map;

public interface UserService {
    User findByLogin(String login);
    void save(User object);
    User update(User object);
    boolean removeByLogin(String name);
    Map<String, User> getMap();
}
