package com.company.actions;

import com.company.ActionRole;
import com.company.api.TaskWebServiceEndpoint;
import com.company.apiClient.Action;
import com.company.apiClient.ServiceLocatorEndpoint;
import com.company.api.Session;
import lombok.SneakyThrows;

public class TaskRemoveAction implements Action {
    private ServiceLocatorEndpoint serviceLocatorEndpoint;

    @Override
    public String getName() {
        return "removeTask";
    }

    @Override
    public String getDescription() {
        return "RemoveByName your task";
    }

    @Override
    @SneakyThrows
    public void execute() {
        String answerNameTask = CommonReader.getNameTask();

        Session session = serviceLocatorEndpoint.getClientSessionService().getSession();
        TaskWebServiceEndpoint taskWebService = serviceLocatorEndpoint.getTaskWebService();
        boolean removeTask = taskWebService.removeByNameTask(answerNameTask, session);
        if (removeTask) {
            System.out.println("Готово");
        } else {
            System.out.println("Неудачно");
        }
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