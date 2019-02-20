package com.company.service;

import com.company.api.Repository;
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
    private Repository<String, Project> projectRepository;
    private final ConnectionSupplier connectionSupplier;

    public ProjectServiceImpl(Repository<String, Project> projectRepository, ConnectionSupplier connectionSupplier) {
        this.projectRepository = projectRepository;
        this.connectionSupplier = connectionSupplier;

    }

    @Override
    @SneakyThrows
    public void save(Project object) {
        projectRepository = new ProjectRepositoryImpl(connectionSupplier);
        EntityManager entityManager = connectionSupplier.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        projectRepository.save(object);
        transaction.commit();
    }

    @Override
    @SneakyThrows
    public Optional<Project> findByName(String name) {
        projectRepository = new ProjectRepositoryImpl(connectionSupplier, );
        return projectRepository.findByName(name);
    }

    @Override
    @SneakyThrows
    public Optional<Project> findById(String id) {
        return projectRepository.findById(id);
    }

    @Override
    @SneakyThrows
    public void update(Project object) {
        EntityManager entityManager = connectionSupplier.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        projectRepository.update(object);
        transaction.commit();
    }

    @Override
    @SneakyThrows
    public void removeByName(String name) {
        EntityManager entityManager = connectionSupplier.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        projectRepository.removeByName(name);
        transaction.commit();
    }

    @Override
    @SneakyThrows
    public List<Project> getList() {
        return projectRepository.getList();
    }
}