package com.company.actions;

import com.company.ActionRole;
import com.company.api.ProjectWebServiceEndpoint;
import com.company.api.Session;
import com.company.apiClient.Action;
import com.company.service.ClientSessionService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProjectRemoveAction implements Action {

    @Autowired
    private ProjectWebServiceEndpoint projectWebServiceEndpoint;

    @Autowired
    private ClientSessionService clientSessionService;

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
        Session session = clientSessionService.getSession();
        boolean removeProject = projectWebServiceEndpoint.removeByNameProject(answerNameProject, session);
        if (removeProject) {
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