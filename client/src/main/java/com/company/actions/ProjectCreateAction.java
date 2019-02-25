package com.company.actions;

import com.company.ActionRole;
import com.company.api.ProjectWebServiceEndpoint;
import com.company.apiClient.Action;
import com.company.apiClient.ServiceLocatorEndpoint;
import com.company.api.Project;
import com.company.api.Session;
import com.company.api.User;
import lombok.SneakyThrows;

public class ProjectCreateAction implements Action {
    private ServiceLocatorEndpoint serviceLocatorEndpoint;

    @Override
    public String getName() {
        return "saveProject";
    }

    @Override
    public String getDescription() {
        return "Save your project";
    }

    @Override
    @SneakyThrows
    public void execute() {
        String answerNameProject = CommonReader.getNameProject();
        String answerDescrProject = CommonReader.getDescrProject();
        Session session = serviceLocatorEndpoint.getClientSessionService().getSession();
        ProjectWebServiceEndpoint projectWebService = serviceLocatorEndpoint.getProjectWebService();
        Project saveProject = projectWebService.saveProject(answerNameProject, answerDescrProject, session);
        if (saveProject != null) {
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