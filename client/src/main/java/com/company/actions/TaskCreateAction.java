package com.company.actions;

import com.company.ActionRole;
import com.company.api.*;
import com.company.apiClient.Action;
import com.company.apiClient.ServiceLocatorEndpoint;
import lombok.SneakyThrows;

public class TaskCreateAction implements Action {
    private ServiceLocatorEndpoint serviceLocatorEndpoint;

    @Override
    public String getName() {
        return "saveTask";
    }

    @Override
    public String getDescription() {
        return "Save your task";
    }

    @Override
    @SneakyThrows
    public void execute() {
        String answerNameTask = CommonReader.getNameTask();
        String answerDescrTask = CommonReader.getDescrTask();
        String answerProjectTask = CommonReader.getNameProject();

        Session session = serviceLocatorEndpoint.getClientSessionService().getSession();
        TaskWebServiceEndpoint taskWebService = serviceLocatorEndpoint.getTaskWebService();
        taskWebService.saveTask(answerNameTask, answerDescrTask, answerProjectTask, session);
        System.out.println("Готово");
    }

    @Override
    public void setServiceLocatorEndpoint(ServiceLocatorEndpoint serviceLocatorEndpoint) {
        this.serviceLocatorEndpoint = serviceLocatorEndpoint;
    }

    @Override
    public ActionRole getRole() {
        return ActionRole.USER;
    }
}