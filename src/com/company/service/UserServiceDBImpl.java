package com.company.service;

import com.company.api.UserRepositoryDB;
import com.company.api.UserServiceDB;
import com.company.model.User;

import java.util.List;
import java.util.Optional;

public class UserServiceDBImpl implements UserServiceDB {
    private UserRepositoryDB userRepositoryDB;

    public UserServiceDBImpl(UserRepositoryDB userRepositoryDB) {
        this.userRepositoryDB = userRepositoryDB;
    }

    @Override
    public boolean save(User object) {
        return userRepositoryDB.save(object);
    }

    @Override
    public boolean update(User object) {
        return userRepositoryDB.update(object);
    }

    @Override
    public Optional<User> findByLogin(String login) {
        return userRepositoryDB.findByLogin(login);
    }

    @Override
    public Optional<User> findById(String id) {
        return userRepositoryDB.findById(id);
    }

    @Override
    public boolean removeByLogin(String login) {
        return userRepositoryDB.removeByLogin(login);
    }

    @Override
    public List<User> getList() {
        return userRepositoryDB.getList();
    }
}