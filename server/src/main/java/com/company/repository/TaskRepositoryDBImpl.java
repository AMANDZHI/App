package com.company.repository;

import com.company.api.RepositoryDB;
import com.company.dao.ConnectionSupplier;
import com.company.mapper.TaskMapper;
import com.company.model.Project;
import com.company.model.Task;
import org.apache.ibatis.session.SqlSession;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

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
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
        session.close();
//        SqlSession session = connectionSupplier.getSession();
//        TaskMapper mapper = session.getMapper(TaskMapper.class);
//        mapper.save(object);
//        session.commit();
//        session.close();
    }

    @Override
    public Optional<Task> findByName(String name) {
        SessionFactory sessionFactory = connectionSupplier.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Task task = session.find(Task.class, name);
        session.getTransaction().commit();
        session.close();
        return Optional.of(task);
//        SqlSession session = connectionSupplier.getSession();
//        TaskMapper mapper = session.getMapper(TaskMapper.class);
//        Task task = mapper.findByName(name);
//        session.commit();
//        session.close();
//        return Optional.of(task);
    }

    @Override
    public Optional<Task> findById(String id) {
        SessionFactory sessionFactory = connectionSupplier.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Task task = session.find(Task.class, id);
        session.getTransaction().commit();
        session.close();
        return Optional.of(task);
//        SqlSession session = connectionSupplier.getSession();
//        TaskMapper mapper = session.getMapper(TaskMapper.class);
//        Task task = mapper.findById(id);
//        session.commit();
//        session.close();
//        return Optional.of(task);
    }

    @Override
    public void update(Task object) {
        SessionFactory sessionFactory = connectionSupplier.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(object);
        session.getTransaction().commit();
        session.close();
//        SqlSession session = connectionSupplier.getSession();
//        TaskMapper mapper = session.getMapper(TaskMapper.class);
//        mapper.update(object);
//        session.commit();
//        session.close();
    }

    @Override
    public void removeByName(String name) {
        SessionFactory sessionFactory = connectionSupplier.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Task task = session.find(Task.class, name);
        session.remove(task);
        session.getTransaction().commit();
        session.close();
//        SqlSession session = connectionSupplier.getSession();
//        TaskMapper mapper = session.getMapper(TaskMapper.class);
//        mapper.removeByName(name);
//        session.commit();
//        session.close();
    }

    @Override
    public List<Task> getList() {
        SessionFactory sessionFactory = connectionSupplier.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Task> list = (List<Task>) session.createQuery("from Task");
        session.getTransaction().commit();
        session.close();
        return list;
//        SqlSession session = connectionSupplier.getSession();
//        TaskMapper mapper = session.getMapper(TaskMapper.class);
//        List<Task> list = mapper.getList();
//        session.commit();
//        session.close();
//        return list;
    }
}