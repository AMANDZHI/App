package com.company;

import com.company.api.*;
import com.company.dao.ConnectionSupplier;
import com.company.endpoint.*;
import com.company.model.Project;
import com.company.model.Session;
import com.company.model.Task;
import com.company.repository.*;
import com.company.service.*;

import javax.xml.ws.Endpoint;
import java.util.List;

public class Initializer implements ServiceLocator {
    private final ConnectionSupplier connectionSupplier = new ConnectionSupplier();
    private final UserRepositoryDB userRepositoryDB = new UserRepositoryDBImpl(connectionSupplier);
    private final RepositoryDB<String, Project> projectRepositoryDB = new ProjectRepositoryDBImpl(connectionSupplier);
    private final RepositoryDB<String, Task> taskRepositoryDB = new TaskRepositoryDBImpl(connectionSupplier);
    private final DomainRepository domainRepository = new DomainRepositoryImpl(projectRepositoryDB, userRepositoryDB, taskRepositoryDB);
    private final ServiceDB<String, Project> projectServiceDB = new ProjectServiceDBImpl(projectRepositoryDB);
    private final ServiceDB<String, Task> taskServiceDB = new TaskServiceDBImpl(taskRepositoryDB);
    private final UserServiceDB userServiceDB = new UserServiceDBImpl(userRepositoryDB);
    private final DomainService domainService = new DomainServiceImpl(domainRepository);
    private final SerializationRepository serializationRepository = new SerializationRepositoryImpl();
    private final SerializationService serializationService = new SerializationServiceImpl(serializationRepository);
    private final ServiceLocator serviceLocator = this;
    private final SessionService sessionService = new SessionServiceImpl(serviceLocator);
    private final ProjectWebServiceEndpointImpl projectServiceEndpoint = new ProjectWebServiceEndpointImpl(serviceLocator);
    private final TaskWebServiceEndpointImpl taskServiceEndpoint = new TaskWebServiceEndpointImpl(serviceLocator);
    private final UserWebServiceEndpointImpl userWebServiceEndpoint = new UserWebServiceEndpointImpl(userServiceDB, sessionService);
    private final SessionWebServiceEndpoint sessionWebServiceEndpoint = new SessionWebServiceEndpointImpl(sessionService);

    private final SerializationWebServiceEndpoint serializationWebServiceEndpoint = new SerializationWebServiceEndpointImpl(serviceLocator);

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

    public void run() {
        Endpoint.publish("http://localhost:1986/wss/project", projectServiceEndpoint);
        Endpoint.publish("http://localhost:1987/wss/task", taskServiceEndpoint);
        Endpoint.publish("http://localhost:1988/wss/user", userWebServiceEndpoint);
        Endpoint.publish("http://localhost:1989/wss/session", sessionWebServiceEndpoint);
        Endpoint.publish("http://localhost:1990/wss/serialization", serializationWebServiceEndpoint);
    }
}