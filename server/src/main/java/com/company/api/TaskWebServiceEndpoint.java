package com.company.api;

import com.company.model.Session;
import com.company.model.Task;

import javax.jws.WebService;
import java.util.List;

@WebService
public interface TaskWebServiceEndpoint {

    boolean saveTask(Task object, Session session);

    Task findByNameTask(String name, Session session);

    Task findByIdTask(String id, Session session);

    boolean updateTask(Task object, Session session);

    boolean removeByNameTask(String name, Session session);

    List<Task> getListTask(Session session);
}
