package com.company;

import com.company.api.*;
import com.company.apiClient.Action;
import com.company.apiClient.ServiceLocatorEndpoint;
import com.company.endpoint.*;
import com.company.repository.ClientSessionRepository;
import com.company.service.ClientSessionService;
import com.company.ui.Menu;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Initializer implements ServiceLocatorEndpoint {
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final SessionWebServiceEndpoint sessionWebService = new SessionWebServiceEndpointImplService().getSessionWebServiceEndpointImplPort();
    private final ProjectWebServiceEndpoint projectWebService = new ProjectWebServiceEndpointImplService().getProjectWebServiceEndpointImplPort();
    private final TaskWebServiceEndpoint taskWebService = new TaskWebServiceEndpointImplService().getTaskWebServiceEndpointImplPort();
    private final UserWebServiceEndpoint userWebService = new UserWebServiceEndpointImplService().getUserWebServiceEndpointImplPort();
    private final ClientSessionRepository clientSessionRepository = new ClientSessionRepository();
    private final ClientSessionService clientSessionService = new ClientSessionService(clientSessionRepository);
    private final ServiceLocatorEndpoint serviceLocatorEndpoint = this;
    private final Map<String, Action> map = new HashMap<>();
    private final Menu menu = new Menu(reader, map, serviceLocatorEndpoint);
    private final List<Action> listForAction = new ArrayList<>();
    private final SerializationWebServiceEndpoint serializationWebService = new SerializationWebServiceEndpointImplService().getSerializationWebServiceEndpointImplPort();

    public void run(Class[] classes) {
        init(classes);
        menu.startMenu();
    }

    private void init(Class[] classes) {
        try {
            for (Class aClass : classes) {
                Action o = (Action) aClass.newInstance();
                o.setServiceLocatorEndpoint(serviceLocatorEndpoint);
                listForAction.add(o);
            }

            for (Action action: listForAction) {
                map.put(action.getName(), action);
            }
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public SessionWebServiceEndpoint getSessionWebService() {
        return sessionWebService;
    }

    @Override
    public ProjectWebServiceEndpoint getProjectWebService() {
        return projectWebService;
    }

    @Override
    public TaskWebServiceEndpoint getTaskWebService() {
        return taskWebService;
    }

    @Override
    public UserWebServiceEndpoint getUserWebService() {
        return userWebService;
    }

    @Override
    public ClientSessionService getClientSessionService() {
        return clientSessionService;
    }

    @Override
    public SerializationWebServiceEndpoint getSerializationWebService() {
        return serializationWebService;
    }
}