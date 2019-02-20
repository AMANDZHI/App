package com.company.service;

import com.company.api.UserRepository;
import com.company.api.UserService;
import com.company.dao.ConnectionSupplier;
import com.company.model.User;
import lombok.SneakyThrows;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ConnectionSupplier connectionSupplier;

    public UserServiceImpl(UserRepository userRepository, ConnectionSupplier connectionSupplier) {
        this.userRepository = userRepository;
        this.connectionSupplier = connectionSupplier;
    }

    @Override
    @SneakyThrows
    public void save(User object) {
        EntityManager entityManager = connectionSupplier.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        userRepository.save(object);
        transaction.commit();
    }

    @Override
    public void update(User object) {
        EntityManager entityManager = connectionSupplier.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        userRepository.update(object);
        transaction.commit();
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
    public void removeByLogin(String login) {
        EntityManager entityManager = connectionSupplier.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        userRepository.removeByLogin(login);
        transaction.commit();
    }

    @Override
    public List<User> getList() {
        return userRepository.getList();
    }
}