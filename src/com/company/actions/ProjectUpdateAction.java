package com.company.actions;

import com.company.api.Action;
import com.company.model.Project;
import com.company.api.ServiceLocator;

import java.io.IOException;

public class ProjectUpdateAction implements Action {
    private final ServiceLocator serviceLocator;

    public ProjectUpdateAction(ServiceLocator serviceLocator) {
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
        Project project = serviceLocator.getProjectService().findById(Integer.parseInt(answerIdProject));
        if (project != null) {
            if (project.getUser().equals(serviceLocator.getSessionService().getSession().getUser()) || serviceLocator.getSessionService().getSession().getUser().isAdmin()) {
                Project updateProject = new Project(Integer.parseInt(answerIdProject), answerNameProject, answerDescrProject, serviceLocator.getSessionService().getSession().getUser());
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