package com.company.api;

import com.company.model.Project;
import com.company.model.Session;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface ProjectWebServiceEndpoint {

    @WebMethod
    boolean save(Project object, Session session);

    @WebMethod
    Project findByName(String name, Session session);

    @WebMethod
    Project findById(String id, Session session);

    @WebMethod
    boolean update(Project object, Session session);

    @WebMethod
    boolean removeByName(String name, Session session);

    @WebMethod
    List<Project> getList(Session session);
}
