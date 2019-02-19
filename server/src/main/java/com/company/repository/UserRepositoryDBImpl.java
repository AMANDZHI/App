package com.company.repository;

import com.company.api.UserRepositoryDB;
import com.company.dao.ConnectionSupplier;
import com.company.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

//import javax.persistence.Query;
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
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
        session.close();
//        SqlSession session = connectionSupplier.getSession();
//        UserMapper mapper = session.getMapper(UserMapper.class);
//        mapper.save(object);
//        session.commit();
//        session.close();
    }

    @Override
    public void update(User object) {
        SessionFactory sessionFactory = connectionSupplier.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(object);
        session.getTransaction().commit();
        session.close();
//        SqlSession session = connectionSupplier.getSession();
//        UserMapper mapper = session.getMapper(UserMapper.class);
//        mapper.update(object);
//        session.commit();
//        session.close();
    }

    @Override
    public Optional<User> findByLogin(String login) {
        SessionFactory sessionFactory = connectionSupplier.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
//        User user = session.find(User.class, login);
//        session.getTransaction().commit();
//        session.close();
//        return Optional.of(user);

        Query<User> query = session.createQuery("from USER where login = :login");
        query.setParameter("login", login);
        User user = query.uniqueResult();
//        SqlSession session = connectionSupplier.getSession();
//        UserMapper mapper = session.getMapper(UserMapper.class);
//        User user = mapper.findByLogin(login);
//        session.commit();
//        session.close();
//        return Optional.of(user);
        return Optional.of(user);
    }

    @Override
    public Optional<User> findById(String id) {
        SessionFactory sessionFactory = connectionSupplier.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        User user = session.find(User.class, id);
        session.getTransaction().commit();
        session.close();
        return Optional.of(user);
//        SqlSession session = connectionSupplier.getSession();
//        UserMapper mapper = session.getMapper(UserMapper.class);
//        User user = mapper.findById(id);
//        session.commit();
//        session.close();
//        return Optional.of(user);
    }

    @Override
    public void removeByLogin(String login) {
        SessionFactory sessionFactory = connectionSupplier.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        User user = session.find(User.class, login);
        session.remove(user);
        session.getTransaction().commit();
        session.close();
//        SqlSession session = connectionSupplier.getSession();
//        UserMapper mapper = session.getMapper(UserMapper.class);
//        mapper.removeByLogin(login);
//        session.commit();
//        session.close();
    }

    @Override
    public List<User> getList() {
        SessionFactory sessionFactory = connectionSupplier.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
//        List<User> users = (List<User>) session.createQuery("from USER");
        NativeQuery sqlQuery = session.createSQLQuery("Select * from user_tbl");
        List list = sqlQuery.list();

        session.getTransaction().commit();
        session.close();
        return list;
//        SqlSession session = connectionSupplier.getSession();
//        UserMapper mapper = session.getMapper(UserMapper.class);
//        List<User> list = mapper.getList();
//        session.commit();
//        session.close();
//        return list;
    }
}