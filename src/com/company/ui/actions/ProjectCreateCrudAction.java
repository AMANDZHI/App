package com.company.ui.actions;

import com.company.model.Project;
import com.company.ui.ServiceLocator;
import com.company.ui.util.CommonReader;

import java.io.BufferedReader;
import java.io.IOException;

public class ProjectCreateCrudAction implements CrudAction {
    private final BufferedReader reader;
    private final ServiceLocator serviceLocator;

    public ProjectCreateCrudAction(BufferedReader reader, ServiceLocator serviceLocator) {
        this.reader = reader;
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
        Project newProject = new Project(Integer.parseInt(answerIdProject), answerNameProject, answerDescrProject);
        serviceLocator.getProjectService().save(newProject);
        System.out.println(newProject);
    }
}
