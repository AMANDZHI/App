package com.company;

import com.company.api.*;
import com.company.dao.ConnectionSupplier;
import com.company.endpoint.*;
import com.company.model.Project;
import com.company.model.Task;
import com.company.repository.DomainRepositoryImpl;
import com.company.repository.SerializationRepositoryImpl;
import com.company.service.*;

import javax.xml.ws.Endpoint;

public class Initializer implements ServiceLocator {
    private final ConnectionSupplier connectionSupplier = new ConnectionSupplier();
    private final DomainRepository domainRepository = new DomainRepositoryImpl(connectionSupplier);
    private final Service<String, Project> projectService = new ProjectServiceImpl(connectionSupplier);
    private final Service<String, Task> taskService = new TaskServiceImpl(connectionSupplier);
    private final UserService userService = new UserServiceImpl(connectionSupplier);
    private final DomainService domainService = new DomainServiceImpl(domainRepository);
    private final SerializationRepository serializationRepository = new SerializationRepositoryImpl();
    private final SerializationService serializationService = new SerializationServiceImpl(serializationRepository);
    private final ServiceLocator serviceLocator = this;
    private final SessionService sessionService = new SessionServiceImpl(serviceLocator);
    private final ProjectWebServiceEndpointImpl projectServiceEndpoint = new ProjectWebServiceEndpointImpl(serviceLocator);
    private final TaskWebServiceEndpointImpl taskServiceEndpoint = new TaskWebServiceEndpointImpl(serviceLocator);
    private final UserWebServiceEndpointImpl userWebServiceEndpoint = new UserWebServiceEndpointImpl(userService, sessionService);
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
    public DomainService getDomainServiceImpl() {
        return domainService;
    }

    public void run() {

//        Session session = sessionWebServiceEndpoint.openSession("admin", "admin");
//        User byIdUser = userWebServiceEndpoint.findByIdUser(session.getUserId(), session);
//        Project p3 = projectServiceEndpoint.findByNameProject("Project2", session);
//        Task task = new Task("task7", "task7", p3, byIdUser);
//        taskServiceEndpoint.saveTask(task, session);


        Endpoint.publish("http://localhost:1986/wss/project", projectServiceEndpoint);
        Endpoint.publish("http://localhost:1987/wss/task", taskServiceEndpoint);
        Endpoint.publish("http://localhost:1988/wss/user", userWebServiceEndpoint);
        Endpoint.publish("http://localhost:1989/wss/session", sessionWebServiceEndpoint);
        Endpoint.publish("http://localhost:1990/wss/serialization", serializationWebServiceEndpoint);
    }
}