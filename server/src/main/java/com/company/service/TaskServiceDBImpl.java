package com.company.service;

import com.company.api.ServiceDB;
import com.company.dao.ConnectionSupplier;
import com.company.repository.TaskMapperRepository;
import com.company.model.Task;
import lombok.SneakyThrows;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Optional;

public class TaskServiceDBImpl implements ServiceDB<String, Task> {
    private final ConnectionSupplier connectionSupplier;

    public TaskServiceDBImpl(ConnectionSupplier connectionSupplier) {
        this.connectionSupplier = connectionSupplier;
    }

    @Override
    public void save(Task object) {
        SqlSession session = connectionSupplier.getSession();
        TaskMapperRepository mapper = session.getMapper(TaskMapperRepository.class);
        mapper.save(object);
        session.commit();
        session.close();
    }

    @Override
    @SneakyThrows
    public Optional<Task> findByName(String name) {
        SqlSession session = connectionSupplier.getSession();
        TaskMapperRepository mapper = session.getMapper(TaskMapperRepository.class);
        Task task = mapper.findByName(name);
        session.commit();
        session.close();
        return Optional.of(task);
    }

    @Override
    @SneakyThrows
    public Optional<Task> findById(String id) {
        SqlSession session = connectionSupplier.getSession();
        TaskMapperRepository mapper = session.getMapper(TaskMapperRepository.class);
        Task task = mapper.findById(id);
        session.commit();
        session.close();
        return Optional.of(task);
    }

    @Override
    @SneakyThrows
    public void update(Task object) {
        SqlSession session = connectionSupplier.getSession();
        TaskMapperRepository mapper = session.getMapper(TaskMapperRepository.class);
        mapper.update(object);
        session.commit();
        session.close();
    }

    @Override
    @SneakyThrows
    public void removeByName(String name) {
        SqlSession session = connectionSupplier.getSession();
        TaskMapperRepository mapper = session.getMapper(TaskMapperRepository.class);
        mapper.removeByName(name);
        session.commit();
        session.close();
    }

    @Override
    @SneakyThrows
    public List<Task> getList() {
        SqlSession session = connectionSupplier.getSession();
        TaskMapperRepository mapper = session.getMapper(TaskMapperRepository.class);
        List<Task> list = mapper.getList();
        session.commit();
        session.close();
        return list;
    }
}