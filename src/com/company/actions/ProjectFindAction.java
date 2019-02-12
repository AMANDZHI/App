package com.company.actions;

import com.company.api.Action;
import com.company.api.ServiceLocator;
import com.company.model.Project;

import java.io.IOException;
import java.util.Optional;

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
//        Project findProject = serviceLocator.getProjectService().findByName(answerNameProject);
        Optional<Project> optionalProject = serviceLocator.getProjectServiceDB().findByName(answerNameProject);
        if (optionalProject.isPresent()) {
            if (optionalProject.get().getUser().equals(serviceLocator.getSessionService().getSession().getUser()) || serviceLocator.getSessionService().getSession().getUser().isAdmin()) {
                System.out.println(optionalProject.get());
            } else {
                System.out.println("Нет прав для просмотра проекта");
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