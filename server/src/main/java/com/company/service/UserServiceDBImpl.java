package com.company.service;

import com.company.api.UserRepositoryDB;
import com.company.api.UserServiceDB;
import com.company.model.User;
import lombok.SneakyThrows;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public class UserServiceDBImpl implements UserServiceDB {
    private final UserRepositoryDB userRepositoryDB;

    public UserServiceDBImpl(UserRepositoryDB userRepositoryDB) {
        this.userRepositoryDB = userRepositoryDB;
    }

    @Override
    @SneakyThrows
    public void save(User object) {
        userRepositoryDB.save(object);
    }

    @Override
    public void update(User object) {
        userRepositoryDB.update(object);
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
    public void removeByLogin(String login) {
        userRepositoryDB.removeByLogin(login);
    }

    @Override
    public List<User> getList() {
        return userRepositoryDB.getList();
    }
}