package com.company.actions;

import com.company.ActionRole;
import com.company.api.*;
import com.company.apiClient.Action;
import com.company.service.ClientSessionService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProjectCreateAction implements Action {

    @Autowired
    private ProjectWebServiceEndpoint projectWebServiceEndpoint;

    @Autowired
    private ClientSessionService clientSessionService;

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
        Session session = clientSessionService.getSession();
        ProjectDTO saveProject = projectWebServiceEndpoint.saveProject(answerNameProject, answerDescrProject, session);
        if (saveProject != null) {
            System.out.println("Готово");
        } else {
            System.out.println("Неудачно");
        }
    }

    @Override
    public ActionRole getRole() {
        return ActionRole.USER;
    }
}