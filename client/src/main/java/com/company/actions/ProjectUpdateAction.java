package com.company.actions;

import com.company.ActionRole;
import com.company.api.Project;
import com.company.api.ProjectWebServiceEndpoint;
import com.company.api.Session;
import com.company.apiClient.Action;
import com.company.service.ClientSessionService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProjectUpdateAction implements Action {

    @Autowired
    private ProjectWebServiceEndpoint projectWebServiceEndpoint;

    @Autowired
    private ClientSessionService clientSessionService;

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

        Session session = clientSessionService.getSession();
        Project project = projectWebServiceEndpoint.updateProject(answerNameProject, answerNewNameProject, answerDescrProject, session);
        System.out.println(project);
    }

    @Override
    public ActionRole getRole() {
        return ActionRole.USER;
    }
}