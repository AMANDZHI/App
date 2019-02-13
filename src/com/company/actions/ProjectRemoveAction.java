package com.company.actions;

import com.company.api.Action;
import com.company.api.ServiceLocator;
import com.company.model.Project;
import com.company.util.Role;

import java.io.IOException;
import java.util.Optional;

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
    public boolean execute() throws IOException {
        String answerNameProject = CommonReader.getNameProject();
        Optional<Project> optionalProject = serviceLocator.getProjectServiceDB().findByName(answerNameProject);
        if (optionalProject.isPresent()) {
            if (optionalProject.get().getUser().equals(serviceLocator.getSessionService().getSession().getUser()) || serviceLocator.getSessionService().getSession().getUser().isAdmin()) {
                serviceLocator.getProjectServiceDB().removeByName(answerNameProject);
                System.out.println("Успешно");
                return true;
            } else {
                System.out.println("Не удалось удалить, так как данный проект не ваш");
                return false;
            }
        } else {
            System.out.println("Такого проекта нет");
            return false;
        }
    }

    @Override
    public Role getRole() {
        return Role.USER;
    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }
}