package com.company.dao.config;

import com.company.dao.repository.ProjectRepository;
import com.company.dao.repository.Repository;
import com.company.dao.repository.TaskRepository;
import com.company.dao.repository.UserRepository;
import com.company.model.Project;
import com.company.model.Task;
import com.company.model.User;
import com.company.service.ProjectServiceImpl;
import com.company.service.Service;
import com.company.service.TaskServiceImpl;
import com.company.service.UserServiceImpl;
import com.company.ui.Menu;
import com.company.ui.ServiceLocator;
import com.company.ui.actions.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Initializer implements ServiceLocator {
    private final Repository<Project> projectRepository = new ProjectRepository();
    private final Repository<Task> taskRepository = new TaskRepository();
    private final Repository<User> userRepository = new UserRepository();
    private final Service<Project> projectService = new ProjectServiceImpl(projectRepository, taskRepository);
    private final Service<Task> taskService = new TaskServiceImpl(taskRepository);
    private final Service<User> userService = new UserServiceImpl(userRepository);
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final ServiceLocator serviceLocator = this;
    private final CrudAction saveProject = new ProjectCreateCrudAction(serviceLocator);
    private final CrudAction findProject = new ProjectFindCrudAction(serviceLocator);
    private final CrudAction updateProject = new ProjectUpdateCrudAction(serviceLocator);
    private final CrudAction removeProject = new ProjectRemoveCrudAction(serviceLocator);
    private final CrudAction getListProjects = new ProjectsGetCrudAction(serviceLocator);
    private final CrudAction saveTask = new TaskCreateCrudAction(serviceLocator);
    private final CrudAction findTask = new TaskFindCrudAction(serviceLocator);
    private final CrudAction updateTask = new TaskUpdateCrudAction(serviceLocator);
    private final CrudAction removeTask = new TaskRemoveCrudAction(serviceLocator);
    private final CrudAction getListTasks = new TasksGetCrudAction(serviceLocator);
    private final AppSecurityConfig appSecurityConfig = new AppSecurityConfig(serviceLocator);
    private final HashMap<String, CrudAction> map = new HashMap<>();

    @Override
    public Service<Project> getProjectService() {
        return projectService;
    }

    @Override
    public Service<Task> getTaskService() {
        return taskService;
    }

    @Override
    public Service<User> getUserService() {
        return userService;
    }

    {
        map.put(saveProject.getName(), saveProject);
        map.put(findProject.getName(), findProject);
        map.put(updateProject.getName(), updateProject);
        map.put(removeProject.getName(), removeProject);
        map.put(getListProjects.getName(), getListProjects);
        map.put(saveTask.getName(), saveTask);
        map.put(findTask.getName(), findTask);
        map.put(updateTask.getName(), updateTask);
        map.put(removeTask.getName(), removeTask);
        map.put(getListTasks.getName(), getListTasks);
    }

    public void run() throws IOException {
        Menu menu = new Menu(reader, map);
        menu.startMenu();
    }
}