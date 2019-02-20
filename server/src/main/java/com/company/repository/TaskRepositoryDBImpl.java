package com.company.repository;

import com.company.api.RepositoryDB;
import com.company.dao.ConnectionSupplier;
import com.company.model.Project;
import com.company.model.Task;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

public class TaskRepositoryDBImpl implements RepositoryDB<String, Task> {
    private final ConnectionSupplier connectionSupplier;

    public TaskRepositoryDBImpl(ConnectionSupplier connectionSupplier) {
        this.connectionSupplier = connectionSupplier;
    }

    @Override
    public void save(Task object) {
        EntityManager entityManager = connectionSupplier.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(object);
        transaction.commit();
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
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(object);
        transaction.commit();
    }

    @Override
    public void removeByName(String name) {
        EntityManager entityManager = connectionSupplier.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Optional<Task> findProject = findByName(name);
        entityManager.remove(findProject.get());
        transaction.commit();
    }

    @Override
    public List<Task> getList() {
        EntityManager entityManager = connectionSupplier.getEntityManager();
        Query query = entityManager.createQuery("from Task");
        return (List<Task>) query.getResultList();
    }
}