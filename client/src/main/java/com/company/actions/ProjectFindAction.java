package com.company.actions;

import com.company.ActionRole;
import com.company.api.ProjectDTO;
import com.company.api.ProjectWebServiceEndpoint;
import com.company.api.Session;
import com.company.apiClient.Action;
import com.company.service.ClientSessionService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProjectFindAction implements Action {

    @Autowired
    private ProjectWebServiceEndpoint projectWebServiceEndpoint;

    @Autowired
    private ClientSessionService clientSessionService;

    @Override
    public String getName() {
        return "findProject";
    }

    @Override
    public String getDescription() {
        return "FindById your project";
    }

    @Override
    @SneakyThrows
    public void execute() {
        String answerNameProject = CommonReader.getNameProject();
        Session session = clientSessionService.getSession();
        ProjectDTO findProject = projectWebServiceEndpoint.findByNameProject(answerNameProject, session);
        if (findProject != null) {
            System.out.println(findProject.getName());
        } else {
            System.out.println("Не удалось найти проект");
        }
    }

    @Override
    public ActionRole getRole() {
        return ActionRole.USER;
    }
}