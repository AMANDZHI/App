package com.company;

import com.company.api.*;
import com.company.dao.ConnectionSupplier;
import com.company.endpoint.*;
import com.company.model.Project;
import com.company.model.Task;
import com.company.repository.*;
import com.company.service.*;

import javax.xml.ws.Endpoint;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Initializer implements ServiceLocator {
    private final ConnectionSupplier connectionSupplier = new ConnectionSupplier();
    private final UserRepositoryDB userRepositoryDB = new UserRepositoryDBImpl(connectionSupplier);
    private final RepositoryDB<String, Project> projectRepositoryDB = new ProjectRepositoryDBImpl(connectionSupplier, userRepositoryDB);
    private final RepositoryDB<String, Task> taskRepositoryDB = new TaskRepositoryDBImpl(connectionSupplier, projectRepositoryDB);
    private final DomainRepository domainRepository = new DomainRepositoryImpl(projectRepositoryDB, userRepositoryDB, taskRepositoryDB);

    private final ServiceDB<String, Project> projectServiceDB = new ProjectServiceDBImpl(projectRepositoryDB);
    private final ServiceDB<String, Task> taskServiceDB = new TaskServiceDBImpl(taskRepositoryDB);
    private final UserServiceDB userServiceDB = new UserServiceDBImpl(userRepositoryDB);
    private final DomainService domainService = new DomainServiceImpl(domainRepository);
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final ServiceLocator serviceLocator = this;
    private final SessionService sessionService = new SessionServiceImpl(serviceLocator);
    private final Map<String, Action> map = new HashMap<>();
    private final ProjectWebServiceEndpoint projectServiceEndpoint = new ProjectWebServiceEndpointImpl(serviceLocator);
    private final TaskWebServiceEndpoint taskServiceEndpoint = new TaskProjectWebServiceEndpointImpl(serviceLocator);
    private final UserWebServiceEndpoint userWebServiceEndpoint = new UserWebServiceEndpointImpl(userServiceDB, sessionService);
    private final SessionWebServiceEndpoint sessionWebServiceEndpoint = new SessionWebServiceEndpointImpl(sessionService);
//    private final Menu menu = new Menu(reader, map, serviceLocator);
    private final List<Action> listForAction = new ArrayList<>();
    private final CommonSerializationRepository commonSerializationRepository = new DomainSerializationRepositoryImpl();
    private final SerializationService serializationService = new DomainSerializationServiceImpl(commonSerializationRepository);

    @Override
    public SessionService getSessionService() {
        return sessionService;
    }

    @Override
    public SerializationService getSerializationServiceImpl() {
        return serializationService;
    }

    @Override
    public ServiceDB<String, Project> getProjectServiceDB() {
        return projectServiceDB;
    }

    @Override
    public ServiceDB<String, Task> getTaskServiceDB() {
        return taskServiceDB;
    }

    @Override
    public UserServiceDB getUserServiceDB() {
        return userServiceDB;
    }

    @Override
    public DomainService getDomainServiceImpl() {
        return domainService;
    }


//    public void run(Class[] classes) {
//        init(classes);
////        menu.startMenu();
//    }
//
//    private void init(Class[] classes) {
//        try {
//            for (Class aClass : classes) {
//                Action o = (Action) aClass.newInstance();
//                o.setServiceLocator(serviceLocator);
//                listForAction.add(o);
//            }
//
//            for (Action action: listForAction) {
//                map.put(action.getName(), action);
//            }
//        } catch (InstantiationException | IllegalAccessException e) {
//            e.printStackTrace();
//        }
//    }

    public void run() {
        Endpoint.publish("http://localhost:1986/wss/project", projectServiceEndpoint);
        Endpoint.publish("http://localhost:1986/wss/task", taskServiceEndpoint);
        Endpoint.publish("http://localhost:1986/wss/user", userWebServiceEndpoint);
        Endpoint.publish("http://localhost:1986/wss/session", sessionWebServiceEndpoint);
    }
}