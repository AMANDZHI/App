package com.company.actions;

import com.company.api.Action;
import com.company.model.Project;
import com.company.api.ServiceLocator;

import java.io.IOException;

public class ProjectRemoveAction implements Action {
    private final ServiceLocator serviceLocator;

    public ProjectRemoveAction(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }


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
        String answerIdProject = CommonReader.getIdProject();
        Project p = serviceLocator.getProjectService().findById(Integer.parseInt(answerIdProject));
        if (p != null) {
            if (p.getUser().equals(serviceLocator.getSessionService().getSession().getUser()) || serviceLocator.getSessionService().getSession().getUser().isAdmin()) {
                serviceLocator.getProjectService().removeById(Integer.parseInt(answerIdProject));
                System.out.println("Успешно");
            } else {
                System.out.println("Не удалось удалить, так как данный проект не ваш");
            }
        } else {
            System.out.println("Такого проекта нет");
        }
    }
}