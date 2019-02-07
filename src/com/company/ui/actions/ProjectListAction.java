package com.company.ui.actions;

import com.company.dao.config.Session;
import com.company.model.Project;
import com.company.ui.ServiceLocator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProjectListAction implements Action {
    private final ServiceLocator serviceLocator;
    private final Session session;

    public ProjectListAction(ServiceLocator serviceLocator, Session session) {
        this.serviceLocator = serviceLocator;
        this.session = session;
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
            if (p.getUser().equals(session.getUser()) || session.getUser().isAdmin()) {
                yourProjects.add(p);
            }
        }
        System.out.println(yourProjects);
    }
}