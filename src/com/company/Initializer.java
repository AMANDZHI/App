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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Initializer implements ServiceLocator {
    private final Repository<String, Project> projectRepository = new ProjectRepositoryImpl();
    private final Repository<String, Task> taskRepository = new TaskRepositoryImpl();
    private final UserRepository userRepository = new UserRepositoryImpl();
    private final SessionRepository sessionRepository = new SessionRepositoryImpl();
    private final Service<String, Project> projectService = new ProjectServiceImpl(projectRepository, taskRepository);
    private final Service<String, Task> taskService = new TaskServiceImpl(taskRepository);
    private final UserService userService = new UserServiceImpl(userRepository);
    private final SessionService sessionService = new SessionServiceImpl(sessionRepository);
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final ServiceLocator serviceLocator = this;
    private final AppSecurity appSecurity = new AppSecurity(serviceLocator);
//    private final Action saveProject = new ProjectCreateAction(serviceLocator);
//    private final Action findProject = new ProjectFindAction(serviceLocator);
//    private final Action updateProject = new ProjectUpdateAction(serviceLocator);
//    private final Action removeProject = new ProjectRemoveAction(serviceLocator);
//    private final Action getListProjects = new ProjectListAction(serviceLocator);
//    private final Action saveTask = new TaskCreateAction(serviceLocator);
//    private final Action findTask = new TaskFindAction(serviceLocator);
//    private final Action updateTask = new TaskUpdateAction(serviceLocator);
//    private final Action removeTask = new TaskRemoveAction(serviceLocator);
//    private final Action getListTasks = new TaskListAction(serviceLocator);
//    private final Action saveUser = new UserCreateAction(serviceLocator);
//    private final Action findUser = new UserFindAction(serviceLocator);
//    private final Action updateUser = new UserUpdateAction(serviceLocator);
//    private final Action removeUser = new UserRemoveAction(serviceLocator);
//    private final Action getListUsers = new UserListAction(serviceLocator);
//    private final Action logOutAction = new LogOutAction(serviceLocator);
//    private final AuthAction loginUser = new LoginAction(serviceLocator);
//    private final AuthAction registration = new RegistrationAction(serviceLocator);
    private final Map<String, Action> map = new HashMap<>();
    private final Map<String, AuthAction> mapAuth = new HashMap<>();
    private final Map<String, Action> mapAdmAction = new HashMap<>();
    private final Menu menu = new Menu(reader, map, mapAuth, mapAdmAction, serviceLocator);
    private final List<Action> listForAction = new ArrayList<>();
    private final List<AuthAction> listForAuth = new ArrayList<>();
    private final List<Action> listForAdmAction = new ArrayList<>();


    @Override
    public Service<String, Project> getProjectService() {
        return projectService;
    }

    @Override
    public Service<String, Task> getTaskService() {
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

    @Override
    public AppSecurity getAppSecurity() {
        return appSecurity;
    }

    {

//        map.put(saveProject.getName(), saveProject);
//        map.put(findProject.getName(), findProject);
//        map.put(updateProject.getName(), updateProject);
//        map.put(removeProject.getName(), removeProject);
//        map.put(getListProjects.getName(), getListProjects);
//        map.put(saveTask.getName(), saveTask);
//        map.put(findTask.getName(), findTask);
//        map.put(updateTask.getName(), updateTask);
//        map.put(removeTask.getName(), removeTask);
//        map.put(getListTasks.getName(), getListTasks);
//
//        mapAuth.put(loginUser.getName(), loginUser);
//        mapAuth.put(registration.getName(), registration);
//
//        mapAdmAction.put(saveProject.getName(), saveProject);
//        mapAdmAction.put(findProject.getName(), findProject);
//        mapAdmAction.put(updateProject.getName(), updateProject);
//        mapAdmAction.put(removeProject.getName(), removeProject);
//        mapAdmAction.put(getListProjects.getName(), getListProjects);
//        mapAdmAction.put(saveTask.getName(), saveTask);
//        mapAdmAction.put(findTask.getName(), findTask);
//        mapAdmAction.put(updateTask.getName(), updateTask);
//        mapAdmAction.put(removeTask.getName(), removeTask);
//        mapAdmAction.put(getListTasks.getName(), getListTasks);
//        mapAdmAction.put(saveUser.getName(), saveUser);
//        mapAdmAction.put(findUser.getName(), findUser);
//        mapAdmAction.put(updateUser.getName(), updateUser);
//        mapAdmAction.put(removeUser.getName(), removeUser);
//        mapAdmAction.put(getListUsers.getName(), getListUsers);
//        mapAdmAction.put(logOutAction.getName(), logOutAction);
        init();
    }

    public void run() throws IOException {
        menu.startMenu();
    }

    public void init() {
        try {
            listForAction.add(ProjectCreateAction.class.newInstance());
            listForAction.add(ProjectFindAction.class.newInstance());
            listForAction.add(ProjectListAction.class.newInstance());
            listForAction.add(ProjectRemoveAction.class.newInstance());
            listForAction.add(ProjectUpdateAction.class.newInstance());
            listForAction.add(TaskCreateAction.class.newInstance());
            listForAction.add(TaskFindAction.class.newInstance());
            listForAction.add(TaskListAction.class.newInstance());
            listForAction.add(TaskRemoveAction.class.newInstance());
            listForAction.add(TaskUpdateAction.class.newInstance());

            listForAuth.add(LoginAction.class.newInstance());
            listForAuth.add(RegistrationAction.class.newInstance());

            listForAdmAction.add(LogOutAction.class.newInstance());
            listForAdmAction.add(UserCreateAction.class.newInstance());
            listForAdmAction.add(UserFindAction.class.newInstance());
            listForAdmAction.add(UserListAction.class.newInstance());
            listForAdmAction.add(UserRemoveAction.class.newInstance());
            listForAdmAction.add(UserUpdateAction.class.newInstance());
            listForAdmAction.addAll(listForAction);


            for (Action action: listForAdmAction) {
                action.setServiceLocator(serviceLocator);
            }

            for (AuthAction action: listForAuth) {
                action.setServiceLocator(serviceLocator);
            }

            for (Action action: listForAction) {
                map.put(action.getName(), action);
            }

            for (AuthAction action: listForAuth) {
                mapAuth.put(action.getName(), action);
            }

            for (Action action: listForAdmAction) {
                mapAdmAction.put(action.getName(), action);
            }

        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }


}