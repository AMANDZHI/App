package com.company.repository;

import com.company.api.Repository;
import com.company.dao.ConnectionSupplier;
import com.company.model.Task;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

public class TaskRepositoryImpl implements Repository<String, Task> {
    private final ConnectionSupplier connectionSupplier;

    public TaskRepositoryImpl(ConnectionSupplier connectionSupplier) {
        this.connectionSupplier = connectionSupplier;
    }

    @Override
    public void save(Task object) {
        EntityManager entityManager = connectionSupplier.getEntityManager();
        entityManager.persist(object);
    }

    @Override
    public Optional<Task> findByName(String name) {
        EntityManager entityManager = connectionSupplier.getEntityManager();
        Query query = entityManager.createQuery("from Task where name = :name");
        query.setParameter("name", name);
        Task task = (Task)query.getSingleResult();
        return Optional.of(task);
    }

    @Override
    public Optional<Task> findById(String id) {
        EntityManager entityManager = connectionSupplier.getEntityManager();
        Task task = entityManager.find(Task.class, id);
        return Optional.of(task);
    }

    @Override
    public void update(Task object) {
        EntityManager entityManager = connectionSupplier.getEntityManager();
        entityManager.merge(object);
    }

    @Override
    public void removeByName(String name) {
        EntityManager entityManager = connectionSupplier.getEntityManager();
        Optional<Task> findProject = findByName(name);
        entityManager.remove(findProject.get());
    }

    @Override
    public List<Task> getList() {
        EntityManager entityManager = connectionSupplier.getEntityManager();
        Query query = entityManager.createQuery("from Task");
        return (List<Task>) query.getResultList();
    }
}