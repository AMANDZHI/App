package com.company.endpoint;

import com.company.api.ServiceLocator;
import com.company.api.TaskWebServiceEndpoint;
import com.company.api.UserServiceDB;
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
    public boolean saveTask(@WebParam(name="task") Task object, @WebParam(name="session") Session session) {
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
    public Task findByNameTask(@WebParam(name="task_name") String name,@WebParam(name="session") Session session) {
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
    public Task findByIdTask(@WebParam(name="task_id") String id,@WebParam(name="session") Session session) {
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
    public boolean updateTask(@WebParam(name="task") Task object,@WebParam(name="session") Session session) {
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
    public boolean removeByNameTask(@WebParam(name="task_name") String name,@WebParam(name="session") Session session) {
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
    public List<Task> getListTask(@WebParam(name="session") Session session) {
        if (serviceLocator.getSessionService().checkSession(session)) {
            List<Task> forClientList = new ArrayList<>();
            List<Task> list = serviceLocator.getTaskServiceDB().getList();
            for (Task task: list) {
                Project project = task.getProject();
                User userProject = project.getUser();
                userProject.getId().equals(session.getUserId());
                UserServiceDB userServiceDB = serviceLocator.getUserServiceDB();
                User user = userServiceDB.findById(session.getUserId()).get();
                if (userProject.getId().equals(session.getUserId()) || user.getRole().equals(UserRole.ADMIN)) {
                    forClientList.add(task);
                }
            }
            return forClientList;
        }
        return null;
    }
}