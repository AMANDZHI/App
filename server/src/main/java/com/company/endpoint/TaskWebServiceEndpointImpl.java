package com.company.endpoint;

import com.company.api.ServiceLocator;
import com.company.api.TaskWebServiceEndpoint;
import com.company.api.UserService;
import com.company.model.Project;
import com.company.model.Session;
import com.company.model.Task;
import com.company.model.User;
import com.company.util.UserRole;
import lombok.SneakyThrows;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@WebService(endpointInterface = "com.company.api.TaskWebServiceEndpoint")
public class TaskWebServiceEndpointImpl implements TaskWebServiceEndpoint {
    private ServiceLocator serviceLocator;

    public TaskWebServiceEndpointImpl() {
    }

    public TaskWebServiceEndpointImpl(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    @WebMethod
    @Override
    public void saveTask(@WebParam(name="task") Task object, @WebParam(name="session") Session session) {
        if (serviceLocator.getSessionService().checkSession(session)) {
            if (object.getUser().getId().equals(session.getUserId()) || serviceLocator.getUserService().findById(session.getUserId()).get().getRole().equals(UserRole.ADMIN)) {
                serviceLocator.getTaskService().save(object);
            }
        }
    }

    @WebMethod
    @SneakyThrows
    @Override
    public Task findByNameTask(@WebParam(name="task_name") String name,@WebParam(name="session") Session session) {
        if (serviceLocator.getSessionService().checkSession(session)) {
            Optional<Task> optionalTask = serviceLocator.getTaskService().findByName(name);

            if (optionalTask.isPresent()) {
                if (optionalTask.get().getUser().getId().equals(session.getUserId()) || serviceLocator.getUserService().findById(session.getUserId()).get().getRole().equals(UserRole.ADMIN)) {
                    return optionalTask.get();
                }
            }
        }
        return null;
    }

    @WebMethod
    @SneakyThrows
    @Override
    public Task findByIdTask(@WebParam(name="task_id") String id,@WebParam(name="session") Session session) {
        if (serviceLocator.getSessionService().checkSession(session)) {
            Optional<Task> optionalTask = serviceLocator.getTaskService().findById(id);

            if (optionalTask.isPresent()) {
                if (optionalTask.get().getUser().getId().equals(session.getUserId()) || serviceLocator.getUserService().findById(session.getUserId()).get().getRole().equals(UserRole.ADMIN)) {
                    return optionalTask.get();
                }
            }
        }
        return null;
    }

    @WebMethod
    @SneakyThrows
    @Override
    public void updateTask(@WebParam(name="task") Task object,@WebParam(name="session") Session session) {
        if (serviceLocator.getSessionService().checkSession(session)) {
            if (object.getUser().getId().equals(session.getUserId()) || serviceLocator.getUserService().findById(session.getUserId()).get().getRole().equals(UserRole.ADMIN)) {
                serviceLocator.getTaskService().update(object);
            }
        }
    }

    @WebMethod
    @SneakyThrows
    @Override
    public void removeByNameTask(@WebParam(name="task_name") String name,@WebParam(name="session") Session session) {
        if (serviceLocator.getSessionService().checkSession(session)) {
            Optional<Task> optionalTask = serviceLocator.getTaskService().findByName(name);

            if (optionalTask.isPresent()) {
                if (optionalTask.get().getUser().getId().equals(session.getUserId()) || serviceLocator.getUserService().findById(session.getUserId()).get().getRole().equals(UserRole.ADMIN)) {
                    serviceLocator.getTaskService().removeByName(name);
                }
            }
        }
    }

    @WebMethod
    @SneakyThrows
    @Override
    public List<Task> getListTask(@WebParam(name="session") Session session) {
        if (serviceLocator.getSessionService().checkSession(session)) {
            List<Task> forClientList = new ArrayList<>();
            List<Task> list = serviceLocator.getTaskService().getList();
            for (Task task: list) {
                User userTask = task.getUser();
                UserService userService = serviceLocator.getUserService();
                User user = userService.findById(session.getUserId()).get();
                if (userTask.getId().equals(session.getUserId()) || user.getRole().equals(UserRole.ADMIN)) {
                    forClientList.add(task);
                }
            }
            return forClientList;
        }
        return null;
    }
}