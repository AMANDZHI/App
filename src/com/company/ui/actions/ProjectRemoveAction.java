package com.company.ui.actions;

import com.company.dao.config.Session;
import com.company.model.Project;
import com.company.ui.ServiceLocator;
import com.company.ui.util.CommonReader;

import java.io.IOException;

public class ProjectRemoveAction implements Action {
    private final ServiceLocator serviceLocator;
    private final Session session;

    public ProjectRemoveAction(ServiceLocator serviceLocator, Session session) {
        this.serviceLocator = serviceLocator;
        this.session = session;
    }


    @Override
    public String getName() {
        return "removeProject";
    }

    @Override
    public String getDescription() {
        return "RemoveById your project";
    }

    @Override
    public void execute() throws IOException {
        String answerIdProject = CommonReader.getIdProject();
        Project p = serviceLocator.getProjectService().findById(Integer.parseInt(answerIdProject));
        if (p != null) {
            if (p.getUser().equals(session.getUser()) || session.getUser().isAdmin()) {
                serviceLocator.getProjectService().removeById(Integer.parseInt(answerIdProject));
                System.out.println("Успешно");
            } else {
                System.out.println("Не удалось удалить, так как данный проект не ваш");
            }
        } else {
            System.out.println("Такого проекта нет");
        }
    }
}