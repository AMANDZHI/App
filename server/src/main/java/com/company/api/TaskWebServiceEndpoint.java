package com.company.api;

import com.company.model.Session;
import com.company.model.Task;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;
import java.util.Optional;

@WebService
public interface TaskWebServiceEndpoint {

    @WebMethod
    boolean save(Task object, Session session);

    @WebMethod
    Task findByName(String name, Session session);

    @WebMethod
    Task findById(String id, Session session);

    @WebMethod
    boolean update(Task object, Session session);

    @WebMethod
    boolean removeByName(String name, Session session);

    @WebMethod
    List<Task> getList(Session session);
}
