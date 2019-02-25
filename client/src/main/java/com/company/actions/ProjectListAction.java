package com.company.actions;

import com.company.ActionRole;
import com.company.api.ProjectWebServiceEndpoint;
import com.company.apiClient.Action;
import com.company.api.Project;
import com.company.api.Session;
import com.company.service.ClientSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProjectListAction implements Action {

    @Autowired
    private ProjectWebServiceEndpoint projectWebServiceEndpoint;

    @Autowired
    private ClientSessionService clientSessionService;

    @Override
    public String getName() {
        return "getListProjects";
    }

    @Override
    public String getDescription() {
        return "Get your all projects";
    }

    @Override
    public void execute() {
        Session session = clientSessionService.getSession();
        List<Project> list = projectWebServiceEndpoint.getListProject(session);
        System.out.println(list);
    }

    @Override
    public ActionRole getRole() {
        return ActionRole.USER;
    }
}