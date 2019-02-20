package com.company.service;

import com.company.api.Repository;
import com.company.api.Service;
import com.company.dao.ConnectionSupplier;
import com.company.model.Task;
import lombok.SneakyThrows;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.Optional;

public class TaskServiceImpl implements Service<String, Task> {
    private final Repository<String, Task> taskRepository;
    private final ConnectionSupplier connectionSupplier;

    public TaskServiceImpl(Repository<String, Task> taskRepository, ConnectionSupplier connectionSupplier) {
        this.taskRepository = taskRepository;
        this.connectionSupplier = connectionSupplier;
    }

    @Override
    public void save(Task object) {
        EntityManager entityManager = connectionSupplier.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        taskRepository.save(object);
        transaction.commit();
    }

    @Override
    @SneakyThrows
    public Optional<Task> findByName(String name) {
        return taskRepository.findByName(name);
    }

    @Override
    @SneakyThrows
    public Optional<Task> findById(String id) {
        return taskRepository.findById(id);
    }

    @Override
    @SneakyThrows
    public void update(Task object) {
        EntityManager entityManager = connectionSupplier.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        taskRepository.update(object);
        transaction.commit();
    }

    @Override
    @SneakyThrows
    public void removeByName(String name) {
        EntityManager entityManager = connectionSupplier.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        taskRepository.removeByName(name);
        transaction.commit();
    }

    @Override
    @SneakyThrows
    public List<Task> getList() {
        return taskRepository.getList();
    }
}