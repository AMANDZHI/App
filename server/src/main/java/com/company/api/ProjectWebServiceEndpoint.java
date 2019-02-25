package com.company.api;

import com.company.model.Project;
import com.company.model.Session;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface ProjectWebServiceEndpoint {

    @WebMethod
    Project saveProject(@WebParam(name="name") String name, @WebParam(name="description") String description , @WebParam(name="session") Session session);

    @WebMethod
    Project findByNameProject(@WebParam(name="project_name") String name,@WebParam(name="session") Session session);

    @WebMethod
    Project findByIdProject(@WebParam(name="project_id") String id,@WebParam(name="session") Session session);

    @WebMethod
    Project updateProject(@WebParam(name="name") String name, @WebParam(name="newName") String newName, @WebParam(name="newDescription") String newDescription, @WebParam(name="session") Session session);

    @WebMethod
    boolean removeByNameProject(@WebParam(name="project_name") String name,@WebParam(name="session") Session session);

    @WebMethod
    List<Project> getListProject(@WebParam(name="session") Session session);
}
