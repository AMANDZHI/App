package com.company.api;

import com.company.model.Session;
import com.company.model.Task;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface TaskWebServiceEndpoint {

    @WebMethod
    Task saveTask(@WebParam(name="name") String nameTask, @WebParam(name="description") String description, @WebParam(name="nameProject") String nameProject, @WebParam(name="session") Session session);

    @WebMethod
    Task findByNameTask(@WebParam(name="task_name") String name,@WebParam(name="session") Session session);

    @WebMethod
    Task findByIdTask(@WebParam(name="task_id") String id,@WebParam(name="session") Session session);

    @WebMethod
    Task updateTask(@WebParam(name="name") String nameTask, @WebParam(name="newName") String newNameTask, @WebParam(name="newDescription") String newDescription, @WebParam(name="newNameProject") String newNameProject,@WebParam(name="session") Session session);

    @WebMethod
    boolean removeByNameTask(@WebParam(name="task_name") String name,@WebParam(name="session") Session session);

    @WebMethod
    List<Task> getListTask(@WebParam(name="session") Session session);
}
