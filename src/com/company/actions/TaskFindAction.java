package com.company.actions;

import com.company.api.Action;
import com.company.model.Task;
import com.company.api.ServiceLocator;

import java.io.IOException;

public class TaskFindAction implements Action {
    private final ServiceLocator serviceLocator;

    public TaskFindAction(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    @Override
    public String getName() {
        return "findTask";
    }

    @Override
    public String getDescription() {
        return "FindById your task";
    }

    @Override
    public void execute() throws IOException {
        String answerIdTask = CommonReader.getIdTask();
        Task findTask = serviceLocator.getTaskService().findById(Integer.parseInt(answerIdTask));
        if (findTask != null) {
            if (findTask.getProject().getUser().equals(serviceLocator.getSessionService().getSession().getUser()) || serviceLocator.getSessionService().getSession().getUser().isAdmin()) {
                System.out.println(findTask);
            } else {
                System.out.println("Данный таск не Ваш");
            }
        } else {
            System.out.println("не найден таск с таким id");
        }
    }
}