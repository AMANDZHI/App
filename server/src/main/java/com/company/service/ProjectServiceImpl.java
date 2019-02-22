package com.company.service;

import com.company.api.Service;
import com.company.dao.ConnectionSupplier;
import com.company.model.Project;
import com.company.repository.ProjectRepositoryImpl;
import lombok.SneakyThrows;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.Optional;

public class ProjectServiceImpl implements Service<String, Project> {
    private final ConnectionSupplier connectionSupplier;

    public ProjectServiceImpl(ConnectionSupplier connectionSupplier) {
        this.connectionSupplier = connectionSupplier;
    }

    @Override
    @SneakyThrows
    public Project save(Project object) {
        EntityManager entityManager = connectionSupplier.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        ProjectRepositoryImpl projectRepository = new ProjectRepositoryImpl(entityManager);
        Project project = projectRepository.save(object);
        transaction.commit();
        return project;
    }

    @Override
    @SneakyThrows
    public Optional<Project> findByName(String name) {
        EntityManager entityManager = connectionSupplier.getEntityManagerFactory().createEntityManager();
        ProjectRepositoryImpl projectRepository = new ProjectRepositoryImpl(entityManager);
        return projectRepository.findByName(name);
    }

    @Override
    @SneakyThrows
    public Optional<Project> findById(String id) {
        EntityManager entityManager = connectionSupplier.getEntityManagerFactory().createEntityManager();
        ProjectRepositoryImpl projectRepository = new ProjectRepositoryImpl(entityManager);
        return projectRepository.findById(id);
    }

    @Override
    @SneakyThrows
    public void update(Project object) {
        EntityManager entityManager = connectionSupplier.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        ProjectRepositoryImpl projectRepository = new ProjectRepositoryImpl(entityManager);
        projectRepository.update(object);
        transaction.commit();
    }

    @Override
    @SneakyThrows
    public void removeByName(String name) {
        EntityManager entityManager = connectionSupplier.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        ProjectRepositoryImpl projectRepository = new ProjectRepositoryImpl(entityManager);
        projectRepository.removeByName(name);
        transaction.commit();
    }

    @Override
    @SneakyThrows
    public List<Project> getList() {
        EntityManager entityManager = connectionSupplier.getEntityManagerFactory().createEntityManager();
        ProjectRepositoryImpl projectRepository = new ProjectRepositoryImpl(entityManager);
        return projectRepository.getList();
    }
}