package com.company.endpoint;

import com.company.api.*;
import com.company.model.Project;
import com.company.model.Session;
import com.company.model.Task;
import com.company.model.User;
import com.company.util.UserRole;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@WebService(endpointInterface = "com.company.api.TaskWebServiceEndpoint")
public class TaskWebServiceEndpointImpl implements TaskWebServiceEndpoint {

    @Autowired
    private SessionService sessionService;

    @Autowired
    @Qualifier("taskService")
    private Service<String, Task> taskService;

    @Autowired
    @Qualifier("projectService")
    private Service<String, Project> projectService;

    @Autowired
    private UserService userService;

    @WebMethod
    @Override
    public void saveTask(@WebParam(name="name") String nameTask, @WebParam(name="description") String description, @WebParam(name="nameProject") String nameProject, @WebParam(name="session") Session session) {
        if (sessionService.checkSession(session)) {
            Optional<Project> optionalProject = projectService.findByName(nameProject);
            if (optionalProject.isPresent()) {
                User userSession = userService.findById(session.getUserId()).get();
                Project project = optionalProject.get();
                User userProject = project.getUser();
                if (userProject.getId().equals(session.getUserId()) || userSession.getRole().equals(UserRole.ADMIN)) {
                    Task task = new Task(nameTask, description, project, userSession);
                    taskService.save(task);
                }
            }
        }
    }

    @WebMethod
    @SneakyThrows
    @Override
    public Task findByNameTask(@WebParam(name="task_name") String name,@WebParam(name="session") Session session) {
        if (sessionService.checkSession(session)) {
            Optional<Task> optionalTask = taskService.findByName(name);

            if (optionalTask.isPresent()) {
                if (optionalTask.get().getUser().getId().equals(session.getUserId()) || userService.findById(session.getUserId()).get().getRole().equals(UserRole.ADMIN)) {
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
        if (sessionService.checkSession(session)) {
            Optional<Task> optionalTask = taskService.findById(id);

            if (optionalTask.isPresent()) {
                if (optionalTask.get().getUser().getId().equals(session.getUserId()) || userService.findById(session.getUserId()).get().getRole().equals(UserRole.ADMIN)) {
                    return optionalTask.get();
                }
            }
        }
        return null;
    }

    @WebMethod
    @SneakyThrows
    @Override
    public Task updateTask(@WebParam(name="name") String nameTask, @WebParam(name="newName") String newNameTask, @WebParam(name="newDescription") String newDescription, @WebParam(name="newNameProject") String newNameProject,@WebParam(name="session") Session session) {
        if (sessionService.checkSession(session)) {
            Optional<Project> optionalProject = projectService.findByName(newNameProject);
            if (optionalProject.isPresent()) {
                Project project = optionalProject.get();
                User userProject = project.getUser();
                User userSession = userService.findById(session.getUserId()).get();
                if (userProject.getId().equals(session.getUserId()) || userSession.getRole().equals(UserRole.ADMIN)) {
                    Optional<Task> optionalTask = taskService.findByName(nameTask);
                    if (optionalTask.isPresent()) {
                        Task task = optionalTask.get();
                        User userTask = task.getUser();
                        if (userTask.getId().equals(session.getUserId()) || userSession.getRole().equals(UserRole.ADMIN)) {
                            task.setName(newNameTask);
                            task.setDescription(newDescription);
                            task.setProject(project);
                            return taskService.update(task);
                        }
                    }
                }
            }
        }
        return null;
    }

    @WebMethod
    @SneakyThrows
    @Override
    public void removeByNameTask(@WebParam(name="task_name") String name,@WebParam(name="session") Session session) {
        if (sessionService.checkSession(session)) {
            Optional<Task> optionalTask = taskService.findByName(name);

            if (optionalTask.isPresent()) {
                if (optionalTask.get().getUser().getId().equals(session.getUserId()) || userService.findById(session.getUserId()).get().getRole().equals(UserRole.ADMIN)) {
                    taskService.removeByName(name);
                }
            }
        }
    }

    @WebMethod
    @SneakyThrows
    @Override
    public List<Task> getListTask(@WebParam(name="session") Session session) {
        if (sessionService.checkSession(session)) {
            List<Task> forClientList = new ArrayList<>();
            List<Task> list = taskService.getList();
            for (Task task: list) {
                User userTask = task.getUser();
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