package com.company.actions;

import com.company.api.Action;
import com.company.api.ServiceLocator;
import com.company.model.Project;
import com.company.util.Role;

import java.io.IOException;

public class ProjectCreateAction implements Action {
    private ServiceLocator serviceLocator;

    @Override
    public String getName() {
        return "saveProject";
    }

    @Override
    public String getDescription() {
        return "Save your project";
    }

    @Override
    public boolean execute() throws IOException {
        String answerNameProject = CommonReader.getNameProject();
        String answerDescrProject = CommonReader.getDescrProject();
        Project newProject = new Project(answerNameProject, answerDescrProject, serviceLocator.getSessionService().getSession().getUser());

        if (!serviceLocator.getProjectServiceDB().findByName(newProject.getName()).isPresent()) {
            if (serviceLocator.getProjectServiceDB().save(newProject)) {
                System.out.println(newProject);
                return true;
            } else {
                System.out.println("Не удалось сохранить проект в базу");
                return false;
            }
        } else {
            System.out.println("Уже есть проект с таким именем");
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