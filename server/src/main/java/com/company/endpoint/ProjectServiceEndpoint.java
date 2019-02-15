package com.company.endpoint;

import com.company.api.ServiceDB;
import com.company.model.Project;
import lombok.SneakyThrows;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;
import java.util.Optional;

@WebService
public class ProjectServiceEndpoint {
    private final ServiceDB<String, Project> projectServiceDB;

    public ProjectServiceEndpoint(ServiceDB<String, Project> projectServiceDB) {
        this.projectServiceDB = projectServiceDB;
    }

    @WebMethod
    @SneakyThrows
    public boolean save(@WebParam(name="project") Project object) {
        return projectServiceDB.save(object);
    }

    @WebMethod
    @SneakyThrows
    public Optional<Project> findByName(@WebParam(name="project_name") String name) {
        return projectServiceDB.findByName(name);
    }

    @WebMethod
    @SneakyThrows
    public Optional<Project> findById(@WebParam(name="project_id") String id) {
        return projectServiceDB.findById(id);
    }

    @WebMethod
    @SneakyThrows
    public boolean update(@WebParam(name="project") Project object) {
        return projectServiceDB.update(object);
    }

    @WebMethod
    @SneakyThrows
    public boolean removeByName(@WebParam(name="project_name") String name) {
        return projectServiceDB.removeByName(name);
    }

    @WebMethod
    @SneakyThrows
    public List<Project> getList() {
        return projectServiceDB.getList();
    }
}
