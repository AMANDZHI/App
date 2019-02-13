package com.company.service;

import com.company.api.RepositoryDB;
import com.company.api.ServiceDB;
import com.company.model.Project;
import lombok.SneakyThrows;

import java.util.List;
import java.util.Optional;

public class ProjectServiceDBImpl implements ServiceDB<String, Project> {
    private final RepositoryDB<String, Project> projectRepositoryDB;

    public ProjectServiceDBImpl(RepositoryDB<String, Project> projectRepositoryDB) {
        this.projectRepositoryDB = projectRepositoryDB;
    }

    @Override
    @SneakyThrows
    public boolean save(Project object) {
        return projectRepositoryDB.save(object);
    }

    @Override
    @SneakyThrows
    public Optional<Project> findByName(String name) {
        return projectRepositoryDB.findByName(name);
    }

    @Override
    @SneakyThrows
    public Optional<Project> findById(String id) {
        return projectRepositoryDB.findById(id);
    }

    @Override
    @SneakyThrows
    public boolean update(Project object) {
        return projectRepositoryDB.update(object);
    }

    @Override
    @SneakyThrows
    public boolean removeByName(String name) {
        return projectRepositoryDB.removeByName(name);
    }

    @Override
    @SneakyThrows
    public List<Project> getList() {
        return projectRepositoryDB.getList();
    }
}