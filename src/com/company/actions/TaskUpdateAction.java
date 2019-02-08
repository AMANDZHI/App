package com.company.actions;

import com.company.api.Action;
import com.company.api.ServiceLocator;
import com.company.model.Project;
import com.company.model.Task;

import java.io.IOException;

public class TaskUpdateAction implements Action {
    private ServiceLocator serviceLocator;

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
        String answerNameTask = CommonReader.getNameTask();
        String answerNewNameTask = CommonReader.getNewNameTask();
        String answerDescrTask = CommonReader.getNewDescrTask();
        String answerProjectTask = CommonReader.getNewNameProjectTask();
        Project project = serviceLocator.getProjectService().findByName(answerProjectTask);
        Task task = serviceLocator.getTaskService().findByName(answerNameTask);
        if (project != null && task != null) {
            if (project.getUser().equals(serviceLocator.getSessionService().getSession().getUser()) || serviceLocator.getSessionService().getSession().getUser().isAdmin()) {
                task.setName(answerNewNameTask);
                task.setDescription(answerDescrTask);
                task.setProject(project);
                serviceLocator.getTaskService().update(task);
            }
            else {
                System.out.println("Нет прав для обновления задачи - нет доступа к указанному проекту");
            }
        } else {
            System.out.println("не найден указанный вами проект или таск ");
        }
    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }
}