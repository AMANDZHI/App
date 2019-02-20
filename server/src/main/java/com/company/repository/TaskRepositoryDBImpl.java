package com.company.repository;

import com.company.api.RepositoryDB;
import com.company.dao.ConnectionSupplier;
import com.company.model.Task;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class TaskRepositoryDBImpl implements RepositoryDB<String, Task> {
    private final ConnectionSupplier connectionSupplier;

    public TaskRepositoryDBImpl(ConnectionSupplier connectionSupplier) {
        this.connectionSupplier = connectionSupplier;
    }

    @Override
    public void save(Task object) {
        SessionFactory sessionFactory = connectionSupplier.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(object);
        transaction.commit();
        session.close();
    }

    @Override
    public Optional<Task> findByName(String name) {
        SessionFactory sessionFactory = connectionSupplier.getSessionFactory();
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Task where name = :name");
        query.setParameter("name", name);
        Task task = (Task)query.uniqueResult();
        session.close();
        return Optional.of(task);
    }

    @Override
    public Optional<Task> findById(String id) {
        SessionFactory sessionFactory = connectionSupplier.getSessionFactory();
        Session session = sessionFactory.openSession();
        Task task = session.find(Task.class, id);
        session.close();
        return Optional.of(task);
    }

    @Override
    public void update(Task object) {
        SessionFactory sessionFactory = connectionSupplier.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(object);
        transaction.commit();
        session.close();
    }

    @Override
    public void removeByName(String name) {
        SessionFactory sessionFactory = connectionSupplier.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Optional<Task> findTask = findByName(name);
        session.remove(findTask.get());
        transaction.commit();
        session.close();
    }

    @Override
    public List<Task> getList() {
        SessionFactory sessionFactory = connectionSupplier.getSessionFactory();
        Session session = sessionFactory.openSession();
        List<Task> list = (List<Task>) session.createQuery("from Task").list();
        session.close();
        return list;
    }
}