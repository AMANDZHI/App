package com.company.service;

import com.company.api.Service;
import com.company.dao.ConnectionSupplier;
import com.company.model.Task;
import com.company.repository.TaskRepositoryImpl;
import lombok.SneakyThrows;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.Optional;

public class TaskServiceImpl implements Service<String, Task> {
    private final ConnectionSupplier connectionSupplier;

    public TaskServiceImpl(ConnectionSupplier connectionSupplier) {
        this.connectionSupplier = connectionSupplier;
    }

    @Override
    public Task save(Task object) {
        EntityManager entityManager = connectionSupplier.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        TaskRepositoryImpl taskRepository = new TaskRepositoryImpl(entityManager);
        Task task = taskRepository.save(object);
        transaction.commit();
        return task;
    }

    @Override
    @SneakyThrows
    public Optional<Task> findByName(String name) {
        EntityManager entityManager = connectionSupplier.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        TaskRepositoryImpl taskRepository = new TaskRepositoryImpl(entityManager);
        transaction.commit();
        return taskRepository.findByName(name);

    }

    @Override
    @SneakyThrows
    public Optional<Task> findById(String id) {
        EntityManager entityManager = connectionSupplier.getEntityManagerFactory().createEntityManager();
        TaskRepositoryImpl taskRepository = new TaskRepositoryImpl(entityManager);
        return taskRepository.findById(id);
    }

    @Override
    @SneakyThrows
    public void update(Task object) {
        EntityManager entityManager = connectionSupplier.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        TaskRepositoryImpl taskRepository = new TaskRepositoryImpl(entityManager);
        taskRepository.update(object);
        transaction.commit();
    }

    @Override
    @SneakyThrows
    public void removeByName(String name) {
        EntityManager entityManager = connectionSupplier.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        TaskRepositoryImpl taskRepository = new TaskRepositoryImpl(entityManager);
        taskRepository.removeByName(name);
        transaction.commit();
    }

    @Override
    @SneakyThrows
    public List<Task> getList() {
        EntityManager entityManager = connectionSupplier.getEntityManagerFactory().createEntityManager();
        TaskRepositoryImpl taskRepository = new TaskRepositoryImpl(entityManager);
        return taskRepository.getList();
    }
}