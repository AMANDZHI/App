package com.company.actions;

import com.company.api.Action;
import com.company.api.ServiceLocator;
import com.company.model.Project;
import com.company.model.Task;
import com.company.util.Role;

import java.io.IOException;
import java.util.Optional;

public class TaskCreateAction implements Action {
    private ServiceLocator serviceLocator;

    @Override
    public String getName() {
        return "saveTask";
    }

    @Override
    public String getDescription() {
        return "Save your task";
    }

    @Override
    public boolean execute() throws IOException {
        String answerNameTask = CommonReader.getNameTask();
        String answerDescrTask = CommonReader.getDescrTask();
        String answerProjectTask = CommonReader.getNameProject();
        if (!serviceLocator.getTaskServiceDB().findByName(answerNameTask).isPresent()) {
            Optional<Project> optionalProject = serviceLocator.getProjectServiceDB().findByName(answerProjectTask);
            if (optionalProject.isPresent()) {
                if (optionalProject.get().getUser().equals(serviceLocator.getSessionService().getSession().getUser()) || serviceLocator.getSessionService().getSession().getUser().isAdmin()) {
                    Task newTask = new Task(answerNameTask, answerDescrTask, optionalProject.get());
                    if (serviceLocator.getTaskServiceDB().save(newTask)) {
                        System.out.println(newTask);
                        return true;
                    } else {
                        System.out.println("Не удалось сохранить таск в базу");
                        return false;
                    }

                } else {
                    System.out.println("Вы не можете создавать задачу для этого проекта");
                    return false;
                }

            } else {
                System.out.println("не найден проект с таким именем");
                return false;
            }
        } else {
            System.out.println("Такое имя таска уже используется");
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