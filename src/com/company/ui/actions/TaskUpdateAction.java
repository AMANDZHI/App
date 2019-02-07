package com.company.ui.actions;

import com.company.dao.config.Session;
import com.company.model.Project;
import com.company.model.Task;
import com.company.ui.ServiceLocator;
import com.company.ui.util.CommonReader;

import java.io.IOException;

public class TaskUpdateAction implements Action {
    private final ServiceLocator serviceLocator;
    private final Session session;

    public TaskUpdateAction(ServiceLocator serviceLocator, Session session) {
        this.serviceLocator = serviceLocator;
        this.session = session;
    }

    @Override
    public String getName() {
        return "updateTask";
    }

    @Override
    public String getDescription() {
        return "Update your task";
    }

    @Override
    public void execute() throws IOException {
        String answerIdTask = CommonReader.getIdTask();
        String answerNameTask = CommonReader.getNewNameTask();;
        String answerDescrTask = CommonReader.getNewDescrTask();
        String answerProjectTask = CommonReader.getNewProjectTask();
        Project project = serviceLocator.getProjectService().findById(Integer.parseInt(answerProjectTask));
        if (project != null) {
            if (project.getUser().equals(session.getUser()) || session.getUser().isAdmin()) {
                Task updateTask = new Task(Integer.parseInt(answerIdTask), answerNameTask, answerDescrTask, project);
                serviceLocator.getTaskService().update(updateTask);
            }
            else {
                System.out.println("Нет прав для обновления задачи - нет доступа к указанному проекту");
            }
        } else {
            System.out.println("не найден указанный вами проект ");
        }
    }
}