package com.company.service;

import com.company.api.RepositoryDB;
import com.company.api.ServiceDB;
import com.company.model.Task;
import lombok.SneakyThrows;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public class TaskServiceDBImpl implements ServiceDB<String, Task> {
    private final RepositoryDB<String, Task> taskRepositoryDB;

    public TaskServiceDBImpl(RepositoryDB<String, Task> taskRepositoryDB) {
        this.taskRepositoryDB = taskRepositoryDB;
    }

    @Override
    @Transactional
    public void save(Task object) {
        taskRepositoryDB.save(object);
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
    @Transactional
    public void update(Task object) {
        taskRepositoryDB.update(object);
    }

    @Override
    @SneakyThrows
    @Transactional
    public void removeByName(String name) {
        taskRepositoryDB.removeByName(name);
    }

    @Override
    @SneakyThrows
    public List<Task> getList() {
        return taskRepositoryDB.getList();
    }
}