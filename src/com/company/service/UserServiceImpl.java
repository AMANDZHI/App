package com.company.service;

import com.company.api.UserRepository;
import com.company.api.UserService;
import com.company.model.User;

import java.util.Map;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void save(User object) {
        userRepository.save(object);
    }

    @Override
    public User findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public User update(User object) {
        return userRepository.update(object);
    }

    @Override
    public boolean removeByLogin(String login) {
        if (findByLogin(login) != null) {
            userRepository.removeByLogin(login);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Map<String, User> getMap() {
        return userRepository.getMap();
    }
}