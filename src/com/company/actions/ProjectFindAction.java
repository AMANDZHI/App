package com.company.actions;

import com.company.api.Action;
import com.company.model.Project;
import com.company.api.ServiceLocator;

import java.io.IOException;

public class ProjectFindAction implements Action {
    private ServiceLocator serviceLocator;

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
        String answerNameProject = CommonReader.getNameProject();
        Project findProject = serviceLocator.getProjectService().findByName(answerNameProject);
        if (findProject != null) {
            if (findProject.getUser().equals(serviceLocator.getSessionService().getSession().getUser()) || serviceLocator.getSessionService().getSession().getUser().isAdmin()) {
                System.out.println(findProject);
            } else {
                System.out.println("Неn прав для просмотра проекта");
            }
        } else {
            System.out.println("Не найден такой проект");
        }

    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }
}