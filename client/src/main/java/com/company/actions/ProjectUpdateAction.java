package com.company.actions;

import com.company.ActionRole;
import com.company.apiClient.Action;
import com.company.apiClient.ServiceLocatorEndpoint;
import com.company.api.Project;
import com.company.api.Session;
import lombok.SneakyThrows;

public class ProjectUpdateAction implements Action {
    private ServiceLocatorEndpoint serviceLocatorEndpoint;

    @Override
    public String getName() {
        return "updateProject";
    }

    @Override
    public String getDescription() {
        return "Update your project";
    }

    @Override
    @SneakyThrows
    public void execute() {
        String answerNameProject = CommonReader.getNameProject();
        String answerNewNameProject = CommonReader.getNewNameProject();
        String answerDescrProject = CommonReader.getNewDescrProject();
        Session session = serviceLocatorEndpoint.getClientSessionService().getSession();
        Project updateProject = serviceLocatorEndpoint.getProjectWebService().findByNameProject(answerNameProject, session);
        updateProject.setName(answerNewNameProject);
        updateProject.setDescription(answerDescrProject);
        serviceLocatorEndpoint.getProjectWebService().updateProject(updateProject, session);
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