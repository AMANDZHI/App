package com.company.actions;

import com.company.api.Action;
import com.company.api.ServiceLocator;
import com.company.model.Project;

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
    public void execute() throws IOException {
        String answerNameProject = CommonReader.getNameProject();
        String answerDescrProject = CommonReader.getDescrProject();
        Project newProject = new Project(answerNameProject, answerDescrProject, serviceLocator.getSessionService().getSession().getUser());
//        serviceLocator.getProjectService().save(newProject);
        if (serviceLocator.getProjectServiceDB().save(newProject)) {
            System.out.println(newProject);
        } else {
            System.out.println("Не удалось сохранить проект в базу");
        }

    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }
}