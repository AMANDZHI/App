package com.company.repository;

import com.company.api.UserRepositoryDB;
import com.company.dao.ConnectionSupplier;
import com.company.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

public class UserRepositoryDBImpl implements UserRepositoryDB {
    private final ConnectionSupplier connectionSupplier;

    public UserRepositoryDBImpl(ConnectionSupplier connectionSupplier) {
        this.connectionSupplier = connectionSupplier;
    }

    @Override
    public void save(User object) {
        EntityManager entityManager = connectionSupplier.getEntityManager();
        entityManager.persist(object);
    }

    @Override
    public void update(User object) {
        EntityManager entityManager = connectionSupplier.getEntityManager();
        entityManager.merge(object);
    }

    @Override
    public Optional<User> findByLogin(String login) {
        EntityManager entityManager = connectionSupplier.getEntityManager();
        Query query = entityManager.createQuery("from User where login = :login");
        query.setParameter("login", login);
        User user = (User)query.getSingleResult();
        return Optional.of(user);
    }

    @Override
    public Optional<User> findById(String id) {
        EntityManager entityManager = connectionSupplier.getEntityManager();
        User user = entityManager.find(User.class, id);
        return Optional.of(user);
    }

    @Override
    public void removeByLogin(String login) {
        EntityManager entityManager = connectionSupplier.getEntityManager();
        Query query = entityManager.createQuery("DELETE FROM User where login = :login");
        query.setParameter("login", login);
        query.executeUpdate();
    }

    @Override
    public List<User> getList() {
        EntityManager entityManager = connectionSupplier.getEntityManager();
        Query query = entityManager.createQuery("from User");
        List<User> list = query.getResultList();
        return list;
    }
}