package com.company.api;

import com.company.model.User;

import java.util.List;

//todo может и не нужен этот интерфейс
public interface UserRepositoryDB {
    User findByLogin(String login);
    void save(User object);
    User update(User object);
    boolean removeByLogin(String name);
    List<User> getList();
}