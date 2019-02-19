package com.company.actions;

import com.company.ActionRole;
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
        User findUser = serviceLocatorEndpoint.getUserWebService().findByIdUser(session.getUserId(), session);
        System.out.println(findUser.getName());
        Project project = new Project();
        project.setName(answerNameProject);
        project.setDescription(answerDescrProject);
        project.setUser(findUser);

        serviceLocatorEndpoint.getProjectWebService().saveProject(project, session);
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