package com.company.actions;

import com.company.api.Action;
import com.company.model.Project;
import com.company.api.ServiceLocator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProjectListAction implements Action {
    private final ServiceLocator serviceLocator;

    public ProjectListAction(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

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
        List<Project> list = serviceLocator.getProjectService().getList();
        for (Project p : list) {
            if (p.getUser().equals(serviceLocator.getSessionService().getSession().getUser()) || serviceLocator.getSessionService().getSession().getUser().isAdmin()) {
                yourProjects.add(p);
            }
        }
        System.out.println(yourProjects);
    }
}