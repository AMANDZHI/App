package com.company.api;

import com.company.model.User;

import java.util.Map;

public interface UserRepository {
    User findByLogin(String login);
    void save(User object);
    User update(User object);
    boolean removeByLogin(String name);
    Map<String, User> getMap();
    void setMap(Map<String, User> map);
}