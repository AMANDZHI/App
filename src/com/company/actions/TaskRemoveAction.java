package com.company.actions;

import com.company.api.Action;
import com.company.model.Task;
import com.company.api.ServiceLocator;

import java.io.IOException;

public class TaskRemoveAction implements Action {
    private final ServiceLocator serviceLocator;

    public TaskRemoveAction(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

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
        String answerIdTask = CommonReader.getIdTask();
        Task task = serviceLocator.getTaskService().findById(Integer.parseInt(answerIdTask));
        if (task != null) {
            if (task.getProject().getUser().equals(serviceLocator.getSessionService().getSession().getUser()) || serviceLocator.getSessionService().getSession().getUser().isAdmin()) {
                serviceLocator.getTaskService().removeById(Integer.parseInt(answerIdTask));
                System.out.println("Успешно удалено");
            } else {
                System.out.println("Не имеет прав для удаления таска");
            }
        } else {
            System.out.println("не найден таск с таким id");
        }
    }
}