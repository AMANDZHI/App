package com.company.repository;

import com.company.api.RepositoryDB;
import com.company.dao.ConnectionSupplier;
import com.company.mapper.TaskMapper;
import com.company.model.Task;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Optional;

public class TaskRepositoryDBImpl implements RepositoryDB<String, Task> {
    private final ConnectionSupplier connectionSupplier;

    public TaskRepositoryDBImpl(ConnectionSupplier connectionSupplier) {
        this.connectionSupplier = connectionSupplier;
    }

    @Override
    public boolean save(Task object) {
        SqlSession session = connectionSupplier.getSession();
        TaskMapper mapper = session.getMapper(TaskMapper.class);
        mapper.save(object);
        session.commit();
        Optional<Task> checkTask = findById(object.getId());
        session.close();
        if (checkTask.isPresent()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Optional<Task> findByName(String name) {
        SqlSession session = connectionSupplier.getSession();
        TaskMapper mapper = session.getMapper(TaskMapper.class);
        Task task = mapper.findByName(name);
        session.commit();
        session.close();
        return Optional.of(task);
    }

    @Override
    public Optional<Task> findById(String id) {
        SqlSession session = connectionSupplier.getSession();
        TaskMapper mapper = session.getMapper(TaskMapper.class);
        Task task = mapper.findById(id);
        session.commit();
        session.close();
        return Optional.of(task);
    }

    @Override
    public boolean update(Task object) {
        SqlSession session = connectionSupplier.getSession();
        TaskMapper mapper = session.getMapper(TaskMapper.class);
        mapper.update(object);
        session.commit();
        Optional<Task> checkTask = findById(object.getId());
        session.close();
        if (checkTask.isPresent()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean removeByName(String name) {
        SqlSession session = connectionSupplier.getSession();
        TaskMapper mapper = session.getMapper(TaskMapper.class);
        mapper.removeByName(name);
        session.commit();
        session.close();
        return true;
    }

    @Override
    public List<Task> getList() {
        SqlSession session = connectionSupplier.getSession();
        TaskMapper mapper = session.getMapper(TaskMapper.class);
        List<Task> list = mapper.getList();
        session.commit();
        session.close();
        return list;
    }
}