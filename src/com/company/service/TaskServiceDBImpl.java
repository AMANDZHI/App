package com.company.service;

import com.company.api.RepositoryDB;
import com.company.api.ServiceDB;
import com.company.model.Task;
import lombok.SneakyThrows;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class TaskServiceDBImpl implements ServiceDB<String, Task> {
    private final RepositoryDB<String, Task> taskRepositoryDB;

    public TaskServiceDBImpl(RepositoryDB<String, Task> taskRepositoryDB) {
        this.taskRepositoryDB = taskRepositoryDB;
    }

    @Override
    public boolean save(Task object) throws IOException, SQLException {
        return taskRepositoryDB.save(object);
    }

    @Override
    @SneakyThrows
    public Optional<Task> findByName(String name) {
        return taskRepositoryDB.findByName(name);
    }

    @Override
    @SneakyThrows
    public Optional<Task> findById(String id) {
        return taskRepositoryDB.findById(id);
    }

    @Override
    @SneakyThrows
    public boolean update(Task object) {
        return taskRepositoryDB.update(object);
    }

    @Override
    @SneakyThrows
    public boolean removeByName(String name) {
        return taskRepositoryDB.removeByName(name);
    }

    @Override
    @SneakyThrows
    public List<Task> getList() {
        return taskRepositoryDB.getList();
    }
}