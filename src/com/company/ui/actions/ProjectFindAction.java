package com.company.ui.actions;

import com.company.dao.config.Session;
import com.company.model.Project;
import com.company.ui.ServiceLocator;
import com.company.ui.util.CommonReader;

import java.io.IOException;

public class ProjectFindAction implements Action {
    private final ServiceLocator serviceLocator;
    private final Session session;

    public ProjectFindAction(ServiceLocator serviceLocator, Session session) {
        this.serviceLocator = serviceLocator;
        this.session = session;
    }

    @Override
    public String getName() {
        return "findProject";
    }

    @Override
    public String getDescription() {
        return "FindById your project";
    }

    @Override
    public void execute() throws IOException {
        String answerIdProject = CommonReader.getIdProject();
        Project findProject = serviceLocator.getProjectService().findById(Integer.parseInt(answerIdProject));
        if (findProject.getUser().equals(session.getUser()) || session.getUser().isAdmin()) {
            System.out.println(findProject);
        } else {
            System.out.println("Не найден такой проект");
        }
    }
}