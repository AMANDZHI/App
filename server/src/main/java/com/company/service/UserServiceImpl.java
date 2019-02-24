package com.company.service;

import com.company.api.UserService;
import com.company.model.User;
import com.company.repository.UserRepositoryData;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepositoryData userRepository;

    @Override
    @SneakyThrows
    @Transactional
    public void save(User object) {
        userRepository.save(object);
    }

    @Override
    @Transactional
    public User update(User object) {
        User user = userRepository.save(object);
        return user;
    }

    @Override
    public Optional<User> findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public Optional<User> findById(String id) {
        return userRepository.findById(id);
    }

    @Override
    @Transactional
    public void removeByLogin(String login) {
        userRepository.deleteByLogin(login);
    }

    @Override
    public List<User> getList() {
        return userRepository.findAll();
    }
}