package com.company.repository;

import com.company.api.RepositoryDB;
import com.company.dao.ConnectionSupplier;
import com.company.model.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class ProjectRepositoryDBImpl implements RepositoryDB<String, Project> {
    private final ConnectionSupplier connectionSupplier;

    public ProjectRepositoryDBImpl(ConnectionSupplier connectionSupplier) {
        this.connectionSupplier = connectionSupplier;
    }

    @Override
    public void save(Project object) {
        SessionFactory sessionFactory = connectionSupplier.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(object);
        transaction.commit();
        session.close();
    }

    @Override
    public Optional<Project> findByName(String name) {
        SessionFactory sessionFactory = connectionSupplier.getSessionFactory();
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Project where name = :name");
        query.setParameter("name", name);
        Project project = (Project)query.uniqueResult();
        session.close();
        return Optional.of(project);
    }

    @Override
    public Optional<Project> findById(String id) {
        SessionFactory sessionFactory = connectionSupplier.getSessionFactory();
        Session session = sessionFactory.openSession();
        Project project = session.find(Project.class, id);
        session.close();
        return Optional.of(project);
    }

    @Override
    public void update(Project object) {
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
        Optional<Project> findProject = findByName(name);
        session.remove(findProject.get());
        transaction.commit();
        session.close();
    }

    @Override
    public List<Project> getList() {
        SessionFactory sessionFactory = connectionSupplier.getSessionFactory();
        Session session = sessionFactory.openSession();
        List<Project> list = (List<Project>) session.createQuery("from Project").list();
        session.close();
        return list;
    }
}
