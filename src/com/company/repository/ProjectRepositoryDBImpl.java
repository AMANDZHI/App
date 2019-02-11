package com.company.repository;

import com.company.api.Repository;
import com.company.model.Project;

import java.util.Map;

public class ProjectRepositoryDBImpl implements Repository<String, Project> {
    private final String

    @Override
    public void save(Project object) {

    }

    @Override
    public Project findByName(String name) {
        return null;
    }

    @Override
    public Project update(Project object) {
        return null;
    }

    @Override
    public boolean removeByName(String name) {
        return false;
    }

    @Override
    public Map<String, Project> getMap() {
        return null;
    }

    @Override
    public void setMap(Map<String, Project> map) {

    }
}
