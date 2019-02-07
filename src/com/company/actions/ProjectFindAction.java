package com.company.actions;

import com.company.api.Action;
import com.company.model.Project;
import com.company.api.ServiceLocator;

import java.io.IOException;

public class ProjectFindAction implements Action {
    private final ServiceLocator serviceLocator;

    public ProjectFindAction(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    @Override
    public String getName() {
        return "findProject";
    }

    @Override
    public String getDescription() {
        return "FindById your project";
    }

    @Override
    public void execute() throws IOException {
        String answerIdProject = CommonReader.getIdProject();
        Project findProject = serviceLocator.getProjectService().findById(Integer.parseInt(answerIdProject));
        if (findProject.getUser().equals(serviceLocator.getSessionService().getSession().getUser()) || serviceLocator.getSessionService().getSession().getUser().isAdmin()) {
            System.out.println(findProject);
        } else {
            System.out.println("Не найден такой проект");
        }
    }
}