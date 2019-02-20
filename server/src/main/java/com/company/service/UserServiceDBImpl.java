package com.company.service;

import com.company.api.UserServiceDB;
import com.company.dao.ConnectionSupplier;
import com.company.repository.UserMapperRepository;
import com.company.model.User;
import lombok.SneakyThrows;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Optional;

public class UserServiceDBImpl implements UserServiceDB {
    private final ConnectionSupplier connectionSupplier;

    public UserServiceDBImpl(ConnectionSupplier connectionSupplier) {
        this.connectionSupplier = connectionSupplier;
    }

    @Override
    @SneakyThrows
    public void save(User object) {
        SqlSession session = connectionSupplier.getSession();
        UserMapperRepository mapper = session.getMapper(UserMapperRepository.class);
        mapper.save(object);
        session.commit();
        session.close();
    }

    @Override
    public void update(User object) {
        SqlSession session = connectionSupplier.getSession();
        UserMapperRepository mapper = session.getMapper(UserMapperRepository.class);
        mapper.update(object);
        session.commit();
        session.close();
    }

    @Override
    public Optional<User> findByLogin(String login) {
        SqlSession session = connectionSupplier.getSession();
        UserMapperRepository mapper = session.getMapper(UserMapperRepository.class);
        User user = mapper.findByLogin(login);
        session.commit();
        session.close();
        return Optional.of(user);
    }

    @Override
    public Optional<User> findById(String id) {
        SqlSession session = connectionSupplier.getSession();
        UserMapperRepository mapper = session.getMapper(UserMapperRepository.class);
        User user = mapper.findById(id);
        session.commit();
        session.close();
        return Optional.of(user);
    }

    @Override
    public void removeByLogin(String login) {
        SqlSession session = connectionSupplier.getSession();
        UserMapperRepository mapper = session.getMapper(UserMapperRepository.class);
        mapper.removeByLogin(login);
        session.commit();
        session.close();
    }

    @Override
    public List<User> getList() {
        SqlSession session = connectionSupplier.getSession();
        UserMapperRepository mapper = session.getMapper(UserMapperRepository.class);
        List<User> list = mapper.getList();
        session.commit();
        session.close();
        return list;
    }
}