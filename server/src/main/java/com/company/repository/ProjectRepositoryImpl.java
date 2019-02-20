package com.company.repository;

import com.company.api.Repository;
import com.company.dao.ConnectionSupplier;
import com.company.model.Project;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

public class ProjectRepositoryImpl implements Repository<String, Project> {
    private final ConnectionSupplier connectionSupplier;

    public ProjectRepositoryImpl(ConnectionSupplier connectionSupplier) {
        this.connectionSupplier = connectionSupplier;
    }

    @Override
    public void save(Project object) {
        EntityManager entityManager = connectionSupplier.getEntityManager();
        entityManager.persist(object);
    }

    @Override
    public Optional<Project> findByName(String name) {
        EntityManager entityManager = connectionSupplier.getEntityManager();
        Query query = entityManager.createQuery("from Project where name = :name");
        query.setParameter("name", name);
        Project project = (Project)query.getSingleResult();
        return Optional.of(project);
    }

    @Override
    public Optional<Project> findById(String id) {
        EntityManager entityManager = connectionSupplier.getEntityManager();
        Project project = entityManager.find(Project.class, id);
        return Optional.of(project);
    }

    @Override
    public void update(Project object) {
        EntityManager entityManager = connectionSupplier.getEntityManager();
        entityManager.merge(object);
    }

    @Override
    public void removeByName(String name) {
        EntityManager entityManager = connectionSupplier.getEntityManager();
        Optional<Project> findProject = findByName(name);
        entityManager.remove(findProject.get());
    }

    @Override
    public List<Project> getList() {
        EntityManager entityManager = connectionSupplier.getEntityManager();
        Query query = entityManager.createQuery("from Project");
        return (List<Project>) query.getResultList();
    }
}
