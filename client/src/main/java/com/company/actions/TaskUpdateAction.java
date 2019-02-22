package com.company.actions;

import com.company.ActionRole;
import com.company.api.TaskWebServiceEndpoint;
import com.company.apiClient.Action;
import com.company.apiClient.ServiceLocatorEndpoint;
import com.company.api.Project;
import com.company.api.Session;
import com.company.api.Task;
import lombok.SneakyThrows;

public class TaskUpdateAction implements Action {
    private ServiceLocatorEndpoint serviceLocatorEndpoint;

    @Override
    public String getName() {
        return "updateTask";
    }

    @Override
    public String getDescription() {
        return "Update your task";
    }

    @Override
    @SneakyThrows
    public void execute() {
        String answerNameTask = CommonReader.getNameTask();
        String answerNewNameTask = CommonReader.getNewNameTask();
        String answerDescrTask = CommonReader.getNewDescrTask();
        String answerProjectTask = CommonReader.getNewNameProjectTask();
        Session session = serviceLocatorEndpoint.getClientSessionService().getSession();
        TaskWebServiceEndpoint taskWebService = serviceLocatorEndpoint.getTaskWebService();
        Task task = taskWebService.updateTask(answerNameTask, answerNewNameTask, answerDescrTask, answerProjectTask, session);
        System.out.println(task);
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