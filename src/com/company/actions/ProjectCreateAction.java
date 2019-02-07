package com.company.actions;

import com.company.api.Action;
import com.company.api.ServiceLocator;
import com.company.model.Project;

import java.io.IOException;

public class ProjectCreateAction implements Action {
    private final ServiceLocator serviceLocator;

    public ProjectCreateAction(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

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
        String answerIdProject = CommonReader.getIdProject();
        String answerNameProject = CommonReader.getNameProject();
        String answerDescrProject = CommonReader.getDescrProject();
        Project newProject = new Project(Integer.parseInt(answerIdProject), answerNameProject, answerDescrProject, serviceLocator.getSessionService().getSession().getUser());
        serviceLocator.getProjectService().save(newProject);
        System.out.println(newProject);
    }
}