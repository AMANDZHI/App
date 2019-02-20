package com.company.repository;

import com.company.api.UserRepositoryDB;
import com.company.dao.ConnectionSupplier;
import com.company.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class UserRepositoryDBImpl implements UserRepositoryDB {
    private final ConnectionSupplier connectionSupplier;

    public UserRepositoryDBImpl(ConnectionSupplier connectionSupplier) {
        this.connectionSupplier = connectionSupplier;
    }

    @Override
    public void save(User object) {
        SessionFactory sessionFactory = connectionSupplier.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(object);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(User object) {
        SessionFactory sessionFactory = connectionSupplier.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(object);
        transaction.commit();
        session.close();
    }

    @Override
    public Optional<User> findByLogin(String login) {
        SessionFactory sessionFactory = connectionSupplier.getSessionFactory();
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from User where login = :login");
        query.setParameter("login", login);
        User user = (User)query.uniqueResult();
        return Optional.of(user);
    }

    @Override
    public Optional<User> findById(String id) {
        SessionFactory sessionFactory = connectionSupplier.getSessionFactory();
        Session session = sessionFactory.openSession();
        User user = session.find(User.class, id);
        session.close();
        return Optional.of(user);
    }

    @Override
    public void removeByLogin(String login) {
        SessionFactory sessionFactory = connectionSupplier.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Optional<User> findUser = findByLogin(login);
        session.remove(findUser.get());
        transaction.commit();
        session.close();
    }

    @Override
    public List<User> getList() {
        SessionFactory sessionFactory = connectionSupplier.getSessionFactory();
        Session session = sessionFactory.openSession();
        List<User> list = session.createQuery("from User").list();
        session.close();
        return list;
    }
}