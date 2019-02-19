package com.company.repository;

import com.company.api.UserRepositoryDB;
import com.company.dao.ConnectionSupplier;
import com.company.mapper.UserMapper;
import com.company.model.User;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Optional;

public class UserRepositoryDBImpl implements UserRepositoryDB {
    private final ConnectionSupplier connectionSupplier;

    public UserRepositoryDBImpl(ConnectionSupplier connectionSupplier) {
        this.connectionSupplier = connectionSupplier;
    }

    @Override
    public void save(User object) {
        SqlSession session = connectionSupplier.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        mapper.save(object);
        session.commit();
        session.close();
    }

    @Override
    public void update(User object) {
        SqlSession session = connectionSupplier.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        mapper.update(object);
        session.commit();
        session.close();
    }

    @Override
    public Optional<User> findByLogin(String login) {
        SqlSession session = connectionSupplier.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.findByLogin(login);
        session.commit();
        session.close();
        return Optional.of(user);
    }

    @Override
    public Optional<User> findById(String id) {
        SqlSession session = connectionSupplier.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.findById(id);
        session.commit();
        session.close();
        return Optional.of(user);
    }

    @Override
    public void removeByLogin(String login) {
        SqlSession session = connectionSupplier.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        mapper.removeByLogin(login);
        session.commit();
        session.close();
    }

    @Override
    public List<User> getList() {
        SqlSession session = connectionSupplier.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> list = mapper.getList();
        session.commit();
        session.close();
        return list;
    }
}