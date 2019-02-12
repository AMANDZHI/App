package com.company.actions;

import com.company.api.Action;
import com.company.api.ServiceLocator;
import com.company.model.Task;

import java.io.IOException;
import java.util.Optional;

public class TaskFindAction implements Action {
    private ServiceLocator serviceLocator;

    @Override
    public String getName() {
        return "findTask";
    }

    @Override
    public String getDescription() {
        return "FindByName your task";
    }

    @Override
    public void execute() throws IOException {
        String answerNameTask = CommonReader.getNameTask();
        Optional<Task> optionalTask = serviceLocator.getTaskServiceDB().findByName(answerNameTask);
        if (optionalTask.isPresent()) {
            if (optionalTask.get().getProject().getUser().equals(serviceLocator.getSessionService().getSession().getUser()) || serviceLocator.getSessionService().getSession().getUser().isAdmin()) {
                System.out.println(optionalTask.get());
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