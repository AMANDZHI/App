package com.company.actions;

import com.company.api.Action;
import com.company.model.Task;
import com.company.api.ServiceLocator;

import java.io.IOException;

public class TaskFindAction implements Action {
    private ServiceLocator serviceLocator;

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
        String answerNameTask = CommonReader.getNameTask();
        Task findTask = serviceLocator.getTaskService().findByName(answerNameTask);
        if (findTask != null) {
            if (findTask.getProject().getUser().equals(serviceLocator.getSessionService().getSession().getUser()) || serviceLocator.getSessionService().getSession().getUser().isAdmin()) {
                System.out.println(findTask);
            } else {
                System.out.println("Данный таск не Ваш");
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