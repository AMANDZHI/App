package com.company.endpoint;

import com.company.api.ServiceLocator;
import com.company.api.TaskWebServiceEndpoint;
import com.company.model.Session;
import com.company.model.Task;
import com.company.util.UserRole;
import lombok.SneakyThrows;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@javax.jws.WebService(endpointInterface = "com.company.api.TaskWebServiceEndpoint")
public class TaskProjectWebServiceEndpointImpl implements TaskWebServiceEndpoint {
    private ServiceLocator serviceLocator;

    public TaskProjectWebServiceEndpointImpl(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    @WebMethod
    @Override
    public boolean save(@WebParam(name="task") Task object, @WebParam(name="session") Session session) {
        if (serviceLocator.getSessionService().checkSession(session)) {
            if (object.getProject().getUser().getId().equals(session.getUserId()) || serviceLocator.getUserServiceDB().findById(session.getUserId()).get().getRole().equals(UserRole.ADMIN)) {
                return serviceLocator.getTaskServiceDB().save(object);
            }
        }
        return false;
    }

    @WebMethod
    @SneakyThrows
    @Override
    public Task findByName(@WebParam(name="task_name") String name,@WebParam(name="session") Session session) {
        if (serviceLocator.getSessionService().checkSession(session)) {
            Optional<Task> optionalTask = serviceLocator.getTaskServiceDB().findByName(name);

            if (optionalTask.isPresent()) {
                if (optionalTask.get().getProject().getUser().getId().equals(session.getUserId()) || serviceLocator.getUserServiceDB().findById(session.getUserId()).get().getRole().equals(UserRole.ADMIN)) {
                    return optionalTask.get();
                }
            }
        }
        return null;
    }

    @WebMethod
    @SneakyThrows
    @Override
    public Task findById(@WebParam(name="task_id") String id,@WebParam(name="session") Session session) {
        if (serviceLocator.getSessionService().checkSession(session)) {
            Optional<Task> optionalTask = serviceLocator.getTaskServiceDB().findById(id);

            if (optionalTask.isPresent()) {
                if (optionalTask.get().getProject().getUser().getId().equals(session.getUserId()) || serviceLocator.getUserServiceDB().findById(session.getUserId()).get().getRole().equals(UserRole.ADMIN)) {
                    return optionalTask.get();
                }
            }
        }
        return null;
    }

    @WebMethod
    @SneakyThrows
    @Override
    public boolean update(@WebParam(name="task") Task object,@WebParam(name="session") Session session) {
        if (serviceLocator.getSessionService().checkSession(session)) {
            if (object.getProject().getUser().getId().equals(session.getUserId()) || serviceLocator.getUserServiceDB().findById(session.getUserId()).get().getRole().equals(UserRole.ADMIN)) {
                return serviceLocator.getTaskServiceDB().update(object);
            }
        }
        return false;
    }

    @WebMethod
    @SneakyThrows
    @Override
    public boolean removeByName(@WebParam(name="task_name") String name,@WebParam(name="session") Session session) {
        if (serviceLocator.getSessionService().checkSession(session)) {
            Optional<Task> optionalTask = serviceLocator.getTaskServiceDB().findByName(name);

            if (optionalTask.isPresent()) {
                if (optionalTask.get().getProject().getUser().getId().equals(session.getUserId()) || serviceLocator.getUserServiceDB().findById(session.getUserId()).get().getRole().equals(UserRole.ADMIN)) {
                    serviceLocator.getTaskServiceDB().removeByName(name);
                }
            }
        }
        return false;
    }

    @WebMethod
    @SneakyThrows
    @Override
    public List<Task> getList(@WebParam(name="session") Session session) {
        if (serviceLocator.getSessionService().checkSession(session)) {
            List<Task> forClientList = new ArrayList<>();
            List<Task> list = serviceLocator.getTaskServiceDB().getList();
            for (Task task: list) {
                if (task.getProject().getUser().getId().equals(session.getUserId()) || serviceLocator.getUserServiceDB().findById(session.getUserId()).get().getRole().equals(UserRole.ADMIN)) {
                    forClientList.add(task);
                }
            }
            return forClientList;
        }
        return null;
    }
}