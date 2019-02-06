package com.company.ui.actions;

import com.company.model.Project;
import com.company.ui.ServiceLocator;
import com.company.ui.util.CommonReader;

import java.io.BufferedReader;
import java.io.IOException;

public class ProjectUpdateCrudAction implements CrudAction {
    private final BufferedReader reader;
    private final ServiceLocator serviceLocator;

    public ProjectUpdateCrudAction(BufferedReader reader, ServiceLocator serviceLocator) {
        this.reader = reader;
        this.serviceLocator = serviceLocator;
    }

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
        String answerIdProject = CommonReader.getIdProject();
        String answerNameProject = CommonReader.getNewNameProject();
        String answerDescrProject = CommonReader.getNewDescrProject();
        Project updateProject = new Project(Integer.parseInt(answerIdProject)-1, answerNameProject, answerDescrProject);
        serviceLocator.getProjectService().update(updateProject);
        System.out.println(updateProject);
    }
}