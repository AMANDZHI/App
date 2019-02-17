package com.company.actions;

import com.company.ActionRole;
import com.company.apiClient.Action;
import com.company.apiClient.ServiceLocatorEndpoint;
import com.company.api.Session;
import lombok.SneakyThrows;


public class ProjectRemoveAction implements Action {
    private ServiceLocatorEndpoint serviceLocatorEndpoint;

    @Override
    public String getName() {
        return "removeProject";
    }

    @Override
    public String getDescription() {
        return "RemoveById your project";
    }

    @Override
    @SneakyThrows
    public void execute() {
        String answerNameProject = CommonReader.getNameProject();
        Session session = serviceLocatorEndpoint.getClientSessionService().getSession();
        boolean answerRemove = serviceLocatorEndpoint.getProjectWebService().removeByNameProject(answerNameProject, session);
        if (answerRemove) {
            System.out.println("Успешно");
        } else {
            System.out.println("Не удалось");
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