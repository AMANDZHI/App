package com.company.actions;

import com.company.api.Action;
import com.company.model.Task;
import com.company.api.ServiceLocator;

import java.io.IOException;

public class TaskRemoveAction implements Action {
    private ServiceLocator serviceLocator;

    @Override
    public String getName() {
        return "removeTask";
    }

    @Override
    public String getDescription() {
        return "RemoveById your task";
    }

    @Override
    public void execute() throws IOException {
        String answerNameTask = CommonReader.getNameTask();
        Task task = serviceLocator.getTaskService().findByName(answerNameTask);
        if (task != null) {
            if (task.getProject().getUser().equals(serviceLocator.getSessionService().getSession().getUser()) || serviceLocator.getSessionService().getSession().getUser().isAdmin()) {
                serviceLocator.getTaskService().removeByName(answerNameTask);
                System.out.println("Успешно удалено");
            } else {
                System.out.println("Не имеет прав для удаления таска");
            }
        } else {
            System.out.println("не найден таск с таким именем");
        }
    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }
}