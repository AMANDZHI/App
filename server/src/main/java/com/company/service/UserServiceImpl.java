package com.company.service;

import com.company.api.UserService;
import com.company.dao.ConnectionSupplier;
import com.company.model.User;
import com.company.repository.UserRepositoryImpl;
import lombok.SneakyThrows;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    private final ConnectionSupplier connectionSupplier;

    public UserServiceImpl(ConnectionSupplier connectionSupplier) {
        this.connectionSupplier = connectionSupplier;
    }

    @Override
    @SneakyThrows
    public void save(User object) {
        EntityManager entityManager = connectionSupplier.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        UserRepositoryImpl userRepository = new UserRepositoryImpl(entityManager);
        userRepository.save(object);
        transaction.commit();
    }

    @Override
    public void update(User object) {
        EntityManager entityManager = connectionSupplier.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        UserRepositoryImpl userRepository = new UserRepositoryImpl(entityManager);
        userRepository.update(object);
        transaction.commit();
    }

    @Override
    public Optional<User> findByLogin(String login) {
        EntityManager entityManager = connectionSupplier.getEntityManagerFactory().createEntityManager();
        UserRepositoryImpl userRepository = new UserRepositoryImpl(entityManager);
        return userRepository.findByLogin(login);
    }

    @Override
    public Optional<User> findById(String id) {
        EntityManager entityManager = connectionSupplier.getEntityManagerFactory().createEntityManager();
        UserRepositoryImpl userRepository = new UserRepositoryImpl(entityManager);
        return userRepository.findById(id);
    }

    @Override
    public void removeByLogin(String login) {
        EntityManager entityManager = connectionSupplier.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        UserRepositoryImpl userRepository = new UserRepositoryImpl(entityManager);
        userRepository.removeByLogin(login);
        transaction.commit();
    }

    @Override
    public List<User> getList() {
        EntityManager entityManager = connectionSupplier.getEntityManagerFactory().createEntityManager();
        UserRepositoryImpl userRepository = new UserRepositoryImpl(entityManager);
        return userRepository.getList();
    }
}