package com.company;

import com.company.actions.*;
import com.company.api.*;
import com.company.model.Project;
import com.company.model.Task;
import com.company.repository.*;
import com.company.service.*;
import com.company.ui.Menu;

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
    private final Map<String, Action> map = new HashMap<>();
    private final Map<String, AuthAction> mapAuth = new HashMap<>();
    private final Map<String, Action> mapAdmAction = new HashMap<>();
    private final Menu menu = new Menu(reader, map, mapAuth, mapAdmAction, serviceLocator);
    private final List<Action> listForAction = new ArrayList<>();
    private final List<AuthAction> listForAuth = new ArrayList<>();
    private final List<Action> listForAdmAction = new ArrayList<>();
    private final CommonSerializationRepository projectSerialization = new ProjectSerializationRepositoryImpl();
    private final CommonSerializationRepository taskSerialization = new TaskSerializationRepositoryImpl();
    private final CommonSerializationRepository userSerialization = new UserSerializationRepositoryImpl();
    private final SerializationService projectSerializationService = new ProjectSerializationServiceImpl(projectSerialization);
    private final SerializationService taskSerializationService = new TaskSerializationServiceImpl(taskSerialization);
    private final SerializationService userSerializationService = new TaskSerializationServiceImpl(userSerialization);

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

    @Override
    public SerializationService getProjectSerializationServiceImpl() {
        return projectSerializationService;
    }

    @Override
    public SerializationService getTaskSerializationServiceImpl() {
        return taskSerializationService;
    }

    @Override
    public SerializationService getUserSerializationServiceImpl() {
        return userSerializationService;
    }

    {
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
            listForAction.add(LogOutAction.class.newInstance());

            listForAuth.add(LoginAction.class.newInstance());
            listForAuth.add(RegistrationAction.class.newInstance());

            listForAdmAction.add(UserCreateAction.class.newInstance());
            listForAdmAction.add(UserFindAction.class.newInstance());
            listForAdmAction.add(UserListAction.class.newInstance());
            listForAdmAction.add(UserRemoveAction.class.newInstance());
            listForAdmAction.add(UserUpdateAction.class.newInstance());
            listForAdmAction.add(WriteProjectsToFileAction.class.newInstance());
            listForAdmAction.add(WriteUsersToFileAction.class.newInstance());
            listForAdmAction.add(WriteTasksToFileAction.class.newInstance());
            listForAdmAction.add(WriteAllToFilesTxtAction.class.newInstance());
            listForAdmAction.add(WriteProjectsToJsonAction.class.newInstance());
            listForAdmAction.add(WriteUsersToJsonAction.class.newInstance());
            listForAdmAction.add(WriteTasksToJsonAction.class.newInstance());
            listForAdmAction.add(WriteAllToFilesJsonAction.class.newInstance());
            listForAdmAction.add(ReadFileToProjectsAction.class.newInstance());
            listForAdmAction.add(ReadFileToUsersAction.class.newInstance());
            listForAdmAction.add(ReadFileToTasksAction.class.newInstance());
            listForAdmAction.add(ReadFilesTxtAction.class.newInstance());
            listForAdmAction.add(ReadJsonToProjectsAction.class.newInstance());
            listForAdmAction.add(ReadJsonToUsersAction.class.newInstance());
            listForAdmAction.add(ReadJsonToTasksAction.class.newInstance());
            listForAdmAction.add(ReadFilesJsonAction.class.newInstance());
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