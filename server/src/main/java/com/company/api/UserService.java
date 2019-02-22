package com.company.api;

import com.company.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void save(User object);
    User update(User object);
    Optional<User> findByLogin(String login);
    Optional<User> findById(String id);
    void removeByLogin(String login);
    List<User> getList();
}