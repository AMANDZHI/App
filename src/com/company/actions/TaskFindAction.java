package com.company.actions;

import com.company.api.Action;
import com.company.api.ServiceLocator;
import com.company.model.Task;
import com.company.util.ActionRole;
import com.company.util.UserRole;

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
    public boolean execute() throws IOException {
        String answerNameTask = CommonReader.getNameTask();
        Optional<Task> optionalTask = serviceLocator.getTaskServiceDB().findByName(answerNameTask);
        if (optionalTask.isPresent()) {
            if (optionalTask.get().getProject().getUser().equals(serviceLocator.getSessionService().getSession().getUser()) || serviceLocator.getSessionService().getSession().getUser().getRole().equals(UserRole.ADMIN)) {
                System.out.println(optionalTask.get());
                return true;
            } else {
                System.out.println("Данный таск не Ваш");
                return false;
            }
        } else {
            System.out.println("не найден таск с таким именем");
            return false;
        }
    }

    @Override
    public ActionRole getRole() {
        return ActionRole.USER;
    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }
}