package com.company.actions;

import com.company.api.Action;
import com.company.model.Project;
import com.company.api.ServiceLocator;

import java.io.IOException;

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
        Project project = serviceLocator.getProjectService().findByName(answerNameProject);
        if (project != null) {
            if (project.getUser().equals(serviceLocator.getSessionService().getSession().getUser()) || serviceLocator.getSessionService().getSession().getUser().isAdmin()) {
                project.setName(answerNewNameProject);
                project.setDescription(answerDescrProject);
                serviceLocator.getProjectService().update(project);
                System.out.println(project);
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