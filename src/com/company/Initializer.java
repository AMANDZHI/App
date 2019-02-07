package com.company;

import com.company.api.*;
import com.company.service.AppSecurity;
import com.company.model.Session;
import com.company.repository.*;
import com.company.model.Project;
import com.company.model.Task;
import com.company.service.*;
import com.company.ui.Menu;
import com.company.actions.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Initializer implements ServiceLocator {
    private final Repository<Project> projectRepository = new ProjectRepositoryImpl();
    private final Repository<Task> taskRepository = new TaskRepositoryImpl();
    private final UserRepository userRepository = new UserRepositoryImpl();
    private final SessionRepository sessionRepository = new SessionRepositoryImpl();
    private final Service<Project> projectService = new ProjectServiceImpl(projectRepository, taskRepository);
    private final Service<Task> taskService = new TaskServiceImpl(taskRepository);
    private final UserService userService = new UserServiceImpl(userRepository);
    private final SessionService sessionService = new SessionServiceImpl(sessionRepository);
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final ServiceLocator serviceLocator = this;
    private final Session session = new Session();
    private final AppSecurity appSecurity = new AppSecurity(serviceLocator);
    private final Action saveProject = new ProjectCreateAction(serviceLocator);
    private final Action findProject = new ProjectFindAction(serviceLocator);
    private final Action updateProject = new ProjectUpdateAction(serviceLocator);
    private final Action removeProject = new ProjectRemoveAction(serviceLocator);
    private final Action getListProjects = new ProjectListAction(serviceLocator);
    private final Action saveTask = new TaskCreateAction(serviceLocator);
    private final Action findTask = new TaskFindAction(serviceLocator);
    private final Action updateTask = new TaskUpdateAction(serviceLocator);
    private final Action removeTask = new TaskRemoveAction(serviceLocator);
    private final Action getListTasks = new TaskListAction(serviceLocator);
    private final Action saveUser = new UserCreateAction(serviceLocator);
    private final Action findUser = new UserFindAction(serviceLocator);
    private final Action updateUser = new UserUpdateAction(serviceLocator);
    private final Action removeUser = new UserRemoveAction(serviceLocator);
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

    @Override
    public SessionService getSessionService() {
        return sessionService;
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
        Menu menu = new Menu(reader, map, mapAuth, mapAdmAction, serviceLocator);
        menu.startMenu();
    }
}