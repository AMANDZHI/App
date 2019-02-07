package com.company.dao.config;

import com.company.dao.repository.*;
import com.company.model.Project;
import com.company.model.Task;
import com.company.service.*;
import com.company.ui.Menu;
import com.company.ui.ServiceLocator;
import com.company.ui.actions.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Initializer implements ServiceLocator {
    private final Repository<Project> projectRepository = new ProjectRepositoryImpl();
    private final Repository<Task> taskRepository = new TaskRepositoryImpl();
    private final UserRepository userRepository = new UserRepositoryImpl();
    private final Service<Project> projectService = new ProjectServiceImpl(projectRepository, taskRepository);
    private final Service<Task> taskService = new TaskServiceImpl(taskRepository);
    private final UserService userService = new UserServiceImpl(userRepository);
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final ServiceLocator serviceLocator = this;
    private final Session session = new Session();
    private final AppSecurity appSecurity = new AppSecurity(serviceLocator, session);
    private final Action saveProject = new ProjectCreateAction(serviceLocator, session);
    private final Action findProject = new ProjectFindAction(serviceLocator, session);
    private final Action updateProject = new ProjectUpdateAction(serviceLocator, session);
    private final Action removeProject = new ProjectRemoveAction(serviceLocator, session);
    private final Action getListProjects = new ProjectListAction(serviceLocator, session);
    private final Action saveTask = new TaskCreateAction(serviceLocator, session);
    private final Action findTask = new TaskFindAction(serviceLocator, session);
    private final Action updateTask = new TaskUpdateAction(serviceLocator, session);
    private final Action removeTask = new TaskRemoveAction(serviceLocator, session);
    private final Action getListTasks = new TaskListAction(serviceLocator, session);
    private final Action saveUser = new UserCreateAction(serviceLocator);
    private final Action findUser = new UserFindAction(serviceLocator);
    private final Action updateUser = new UserUpdateAction(serviceLocator, session);
    private final Action removeUser = new UserRemoveAction(serviceLocator, session);
    private final Action getListUsers = new UserListAction(serviceLocator);
    private final Action logOutAction = new LogOutAction(appSecurity);
    private final AuthAction loginUser = new LoginAction(appSecurity, serviceLocator);
    private final AuthAction registration = new RegistrationAction(serviceLocator);
    private final HashMap<String, Action> map = new HashMap<>();
    private final HashMap<String, AuthAction> mapAuth = new HashMap<>();
    private final HashMap<String, Action> mapAdmAction = new HashMap<>();


    @Override
    public Service<Project> getProjectService() {
        return projectService;
    }

    @Override
    public Service<Task> getTaskService() {
        return taskService;
    }

    @Override
    public UserService getUserService() {
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
        
        mapAuth.put(loginUser.getName(), loginUser);
        mapAuth.put(registration.getName(), registration);

        mapAdmAction.put(saveProject.getName(), saveProject);
        mapAdmAction.put(findProject.getName(), findProject);
        mapAdmAction.put(updateProject.getName(), updateProject);
        mapAdmAction.put(removeProject.getName(), removeProject);
        mapAdmAction.put(getListProjects.getName(), getListProjects);
        mapAdmAction.put(saveTask.getName(), saveTask);
        mapAdmAction.put(findTask.getName(), findTask);
        mapAdmAction.put(updateTask.getName(), updateTask);
        mapAdmAction.put(removeTask.getName(), removeTask);
        mapAdmAction.put(getListTasks.getName(), getListTasks);
        mapAdmAction.put(saveUser.getName(), saveUser);
        mapAdmAction.put(findUser.getName(), findUser);
        mapAdmAction.put(updateUser.getName(), updateUser);
        mapAdmAction.put(removeUser.getName(), removeUser);
        mapAdmAction.put(getListUsers.getName(), getListUsers);
        mapAdmAction.put(logOutAction.getName(), logOutAction);
    }

    public void run() throws IOException {
        Menu menu = new Menu(reader, map, mapAuth, mapAdmAction, session);
        menu.startMenu();
    }
}