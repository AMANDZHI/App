package com.company.actions;

import com.company.api.Action;
import com.company.api.ServiceLocator;
import com.company.model.Project;

import java.io.IOException;
import java.util.Optional;

public class ProjectUpdateAction implements Action {
    private ServiceLocator serviceLocator;

    @Override
    public String getName() {
        return "updateProject";
    }

    @Override
    public String getDescription() {
        return "Update your project";
    }

    @Override
    public void execute() throws IOException {
        String answerNameProject = CommonReader.getNameProject();
        String answerNewNameProject = CommonReader.getNewNameProject();
        String answerDescrProject = CommonReader.getNewDescrProject();
//        Project project = serviceLocator.getProjectService().findByName(answerNameProject);
        Optional<Project> optionalProject = serviceLocator.getProjectServiceDB().findByName(answerNameProject);
        if (optionalProject.isPresent()) {
            if (optionalProject.get().getUser().equals(serviceLocator.getSessionService().getSession().getUser()) || serviceLocator.getSessionService().getSession().getUser().isAdmin()) {
                optionalProject.get().setName(answerNewNameProject);
                optionalProject.get().setDescription(answerDescrProject);
                serviceLocator.getProjectService().update(optionalProject.get());
                System.out.println(optionalProject.get());
            } else {
                System.out.println("Не имеете прав для обновления проекта с таким именем");
            }
        } else {
            System.out.println("Не найден проект с таким именем");
        }
    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }
}