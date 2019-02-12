package com.company.service;

import com.company.api.RepositoryDB;
import com.company.api.ServiceDB;
import com.company.model.Task;

import java.util.List;
import java.util.Optional;

public class TaskServiceDBImpl implements ServiceDB<String, Task> {
    private RepositoryDB<String, Task> taskRepositoryDB;

    public TaskServiceDBImpl(RepositoryDB<String, Task> taskRepositoryDB) {
        this.taskRepositoryDB = taskRepositoryDB;
    }

    @Override
    public boolean save(Task object) {
        return taskRepositoryDB.save(object);
    }

    @Override
    public Optional<Task> findByName(String name) {
        return taskRepositoryDB.findByName(name);
    }

    @Override
    public Optional<Task> findById(String id) {
        return taskRepositoryDB.findById(id);
    }

    @Override
    public boolean update(Task object) {
        return taskRepositoryDB.update(object);
    }

    @Override
    public boolean removeByName(String name) {
        return taskRepositoryDB.removeByName(name);
    }

    @Override
    public List<Task> getList() {
        return taskRepositoryDB.getList();
    }
}