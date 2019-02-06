package com.company.ui.actions;

import com.company.ui.ServiceLocator;

import java.io.IOException;

public class ProjectsGetCrudAction implements CrudAction {
    private final ServiceLocator serviceLocator;

    public ProjectsGetCrudAction(ServiceLocator serviceLocator) {
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
        System.out.println(serviceLocator.getProjectService().getList());
    }
}