package com.company.actions;

import com.company.api.Action;
import com.company.api.ServiceLocator;
import com.company.model.Task;
import com.company.util.Role;

import java.io.IOException;
import java.util.Optional;

public class TaskRemoveAction implements Action {
    private ServiceLocator serviceLocator;

    @Override
    public String getName() {
        return "removeTask";
    }

    @Override
    public String getDescription() {
        return "RemoveByName your task";
    }

    @Override
    public boolean execute() throws IOException {
        String answerNameTask = CommonReader.getNameTask();
        Optional<Task> optionalTask = serviceLocator.getTaskServiceDB().findByName(answerNameTask);
        if (optionalTask.isPresent()) {
            if (optionalTask.get().getProject().getUser().equals(serviceLocator.getSessionService().getSession().getUser()) || serviceLocator.getSessionService().getSession().getUser().isAdmin()) {
                if (serviceLocator.getTaskServiceDB().removeByName(answerNameTask)) {
                    System.out.println("Успешно удалено");
                    return true;
                } else {
                    System.out.println("Не удалось удалить из базы");
                    return false;
                }
            } else {
                System.out.println("Не имеет прав для удаления таска");
                return false;
            }
        } else {
            System.out.println("не найден таск с таким именем");
            return false;
        }
    }

    @Override
    public Role getRole() {
        return Role.USER;
    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }
}