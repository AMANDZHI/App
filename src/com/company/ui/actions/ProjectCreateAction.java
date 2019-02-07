package com.company.ui.actions;

import com.company.dao.config.Session;
import com.company.model.Project;
import com.company.ui.ServiceLocator;
import com.company.ui.util.CommonReader;

import java.io.IOException;

public class ProjectCreateAction implements Action {
    private final ServiceLocator serviceLocator;
    private final Session session;

    public ProjectCreateAction(ServiceLocator serviceLocator, Session session) {
        this.serviceLocator = serviceLocator;
        this.session = session;
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
        Project newProject = new Project(Integer.parseInt(answerIdProject), answerNameProject, answerDescrProject, session.getUser());
        serviceLocator.getProjectService().save(newProject);
        System.out.println(newProject);
    }
}
