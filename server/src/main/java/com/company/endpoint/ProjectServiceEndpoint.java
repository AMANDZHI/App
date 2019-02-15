package com.company.endpoint;

import com.company.api.ServiceDB;
import com.company.model.Project;
import lombok.SneakyThrows;

import java.util.List;
import java.util.Optional;

public class ProjectServiceEndpoint {
    private final ServiceDB<String, Project> projectServiceDB;

    public ProjectServiceEndpoint(ServiceDB<String, Project> projectServiceDB) {
        this.projectServiceDB = projectServiceDB;
    }
    
    @SneakyThrows
    public boolean save(Project object) {
        return projectServiceDB.save(object);
    }
    
    @SneakyThrows
    public Optional<Project> findByName(String name) {
        return projectServiceDB.findByName(name);
    }
    
    @SneakyThrows
    public Optional<Project> findById(String id) {
        return projectServiceDB.findById(id);
    }
    
    @SneakyThrows
    public boolean update(Project object) {
        return projectServiceDB.update(object);
    }
    
    @SneakyThrows
    public boolean removeByName(String name) {
        return projectServiceDB.removeByName(name);
    }
    
    @SneakyThrows
    public List<Project> getList() {
        return projectServiceDB.getList();
    }
}
