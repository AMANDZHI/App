package com.company.service;

import com.company.api.RepositoryDB;
import com.company.api.ServiceDB;
import com.company.model.Project;

import java.util.List;
import java.util.Optional;

public class ProjectServiceDBImpl implements ServiceDB<String, Project> {
    private RepositoryDB<String, Project> projectRepositoryDB;

    public ProjectServiceDBImpl(RepositoryDB<String, Project> projectRepositoryDB) {
        this.projectRepositoryDB = projectRepositoryDB;
    }

    @Override
    public boolean save(Project object) {
        return projectRepositoryDB.save(object);
    }

    @Override
    public Optional<Project> findByName(String name) {
        return projectRepositoryDB.findByName(name);
    }

    @Override
    public Optional<Project> findById(String id) {
        return projectRepositoryDB.findById(id);
    }

    @Override
    public boolean update(Project object) {
        return projectRepositoryDB.update(object);
    }

    @Override
    public boolean removeByName(String name) {
        return projectRepositoryDB.removeByName(name);
    }

    @Override
    public List<Project> getList() {
        return projectRepositoryDB.getList();
    }
}