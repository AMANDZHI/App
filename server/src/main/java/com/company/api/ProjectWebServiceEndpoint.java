package com.company.api;

import com.company.model.Project;
import com.company.model.Session;

import javax.jws.WebService;
import java.util.List;

@WebService
public interface ProjectWebServiceEndpoint {

    void saveProject(String name, String description, Session session);

    Project findByNameProject(String name, Session session);

    Project findByIdProject(String id, Session session);

    void updateProject(String name ,String newName, String newDescription, Session session);

    void removeByNameProject(String name, Session session);

    List<Project> getListProject(Session session);
}
