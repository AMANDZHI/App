package com.company.actions;

import com.company.api.Action;
import com.company.api.ServiceLocator;
import com.company.model.Project;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProjectListAction implements Action {
    private ServiceLocator serviceLocator;

    @Override
    public String getName() {
        return "getListProjects";
    }

    @Override
    public String getDescription() {
        return "Get your all projects";
    }

    @Override
    public void execute() throws IOException {
        List<Project> yourProjects = new ArrayList<>();
//        Map<String, Project> map = serviceLocator.getProjectService().getMap();
        List<Project> list = serviceLocator.getProjectServiceDB().getList();
        for (Project project : list) {
            if (project.getUser().equals(serviceLocator.getSessionService().getSession().getUser()) || serviceLocator.getSessionService().getSession().getUser().isAdmin()) {
                yourProjects.add(project);
            }
        }
        System.out.println(yourProjects);
    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }
}