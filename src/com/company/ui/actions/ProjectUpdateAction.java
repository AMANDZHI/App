package com.company.ui.actions;

import com.company.dao.config.Session;
import com.company.model.Project;
import com.company.ui.ServiceLocator;
import com.company.ui.util.CommonReader;

import java.io.IOException;

public class ProjectUpdateAction implements Action {
    private final ServiceLocator serviceLocator;
    private final Session session;

    public ProjectUpdateAction(ServiceLocator serviceLocator, Session session) {
        this.serviceLocator = serviceLocator;
        this.session = session;
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
        Project project = serviceLocator.getProjectService().findById(Integer.parseInt(answerIdProject));
        if (project != null) {
            if (project.getUser().equals(session.getUser()) || session.getUser().isAdmin()) {
                Project updateProject = new Project(Integer.parseInt(answerIdProject), answerNameProject, answerDescrProject, session.getUser());
                serviceLocator.getProjectService().update(updateProject);
                System.out.println(updateProject);
            } else {
                System.out.println("Не имеете прав для обновления проекта с таким id");
            }
        } else {
            System.out.println("Не найден проект с таким id");
        }

    }
}