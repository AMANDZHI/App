package com.company.api;

import com.company.model.Project;
import com.company.model.Session;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface ProjectWebServiceEndpoint {

    boolean saveProject(Project object, Session session);

    Project findByNameProject(String name, Session session);

    Project findByIdProject(String id, Session session);

    boolean updateProject(Project object, Session session);

    boolean removeByNameProject(String name, Session session);

    List<Project> getListProject(Session session);
}
