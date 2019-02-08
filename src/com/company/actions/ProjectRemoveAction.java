package com.company.actions;

import com.company.api.Action;
import com.company.api.ServiceLocator;
import com.company.model.Project;

import java.io.IOException;

public class ProjectRemoveAction implements Action {
    private ServiceLocator serviceLocator;

    @Override
    public String getName() {
        return "removeProject";
    }

    @Override
    public String getDescription() {
        return "RemoveById your project";
    }

    @Override
    public void execute() throws IOException {
        String answerNameProject = CommonReader.getNameProject();
        Project project = serviceLocator.getProjectService().findByName(answerNameProject);
        if (project != null) {
            if (project.getUser().equals(serviceLocator.getSessionService().getSession().getUser()) || serviceLocator.getSessionService().getSession().getUser().isAdmin()) {
                serviceLocator.getProjectService().removeByName(answerNameProject);
                System.out.println("Успешно");
            } else {
                System.out.println("Не удалось удалить, так как данный проект не ваш");
            }
        } else {
            System.out.println("Такого проекта нет");
        }
    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }
}