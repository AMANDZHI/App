package com.company.repository;

import com.company.api.RepositoryDB;
import com.company.dao.ConnectionSupplier;
import com.company.mapper.ProjectMapper;
import com.company.model.Project;
import com.company.model.User;
import org.apache.ibatis.session.SqlSession;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

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
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
        session.close();
//        SqlSession session = connectionSupplier.getSession();
//        ProjectMapper mapper = session.getMapper(ProjectMapper.class);
//        mapper.save(object);
//        session.commit();
//        session.close();
    }

    @Override
    public Optional<Project> findByName(String name) {
        SessionFactory sessionFactory = connectionSupplier.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Project project = session.find(Project.class, name);
        session.getTransaction().commit();
        session.close();
        return Optional.of(project);
//        SqlSession session = connectionSupplier.getSession();
//        ProjectMapper mapper =  session.getMapper(ProjectMapper.class);
//        Project project = mapper.findByName(name);
//        session.commit();
//        session.close();
//        return Optional.of(project);
    }

    @Override
    public Optional<Project> findById(String id) {
        SessionFactory sessionFactory = connectionSupplier.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Project project = session.find(Project.class, id);
        session.getTransaction().commit();
        session.close();
        return Optional.of(project);
//        SqlSession session = connectionSupplier.getSession();
//        ProjectMapper mapper = session.getMapper(ProjectMapper.class);
//        Project project = mapper.findById(id);
//        session.commit();
//        session.close();
//        return Optional.of(project);
    }

    @Override
    public void update(Project object) {
        SessionFactory sessionFactory = connectionSupplier.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(object);
        session.getTransaction().commit();
        session.close();
//        SqlSession session = connectionSupplier.getSession();
//        ProjectMapper mapper = session.getMapper(ProjectMapper.class);
//        mapper.update(object);
//        session.commit();
//        session.close();
    }

    @Override
    public void removeByName(String name) {
        SessionFactory sessionFactory = connectionSupplier.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Project project = session.find(Project.class, name);
        session.remove(project);
        session.getTransaction().commit();
        session.close();
//        SqlSession session = connectionSupplier.getSession();
//        ProjectMapper mapper = session.getMapper(ProjectMapper.class);
//        mapper.removeByName(name);
//        session.commit();
//        session.close();
    }

    @Override
    public List<Project> getList() {
        SessionFactory sessionFactory = connectionSupplier.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Project> list = (List<Project>) session.createQuery("from Project");
        session.getTransaction().commit();
        session.close();
        return list;
//        SqlSession session = connectionSupplier.getSession();
//        ProjectMapper mapper = session.getMapper(ProjectMapper.class);
//        List<Project> list = mapper.getList();
//        session.commit();
//        session.close();
//        return list;
    }
}
