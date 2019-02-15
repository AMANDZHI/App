package com.company.api;

import com.company.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepositoryDB {
    boolean save(User object);
    boolean update(User object);
    Optional<User> findByLogin(String login);
    Optional<User> findById(String id);
    boolean removeByLogin(String login);
    List<User> getList();
}