package com.company.service;

import com.company.dao.repository.Repository;
import com.company.model.User;

import java.util.List;

public class UserServiceImpl implements Service<User> {
    private Repository<User> userRepository;

    public UserServiceImpl(Repository<User> userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void save(User object) {
        userRepository.save(object);
    }

    @Override
    public User findById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public User update(User object) {
        return userRepository.update(object);
    }

    @Override
    public boolean removeById(Integer id) {
        return userRepository.removeById(id);
    }

    @Override
    public List<User> getList() {
        return userRepository.getList();
    }
}