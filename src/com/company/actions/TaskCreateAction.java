package com.company.actions;

import com.company.api.Action;
import com.company.api.ServiceLocator;
import com.company.model.Project;
import com.company.model.Task;

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
    public void execute() throws IOException {
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
                    } else {
                        System.out.println("Не удалось сохранить таск в базу");
                    }

                } else {
                    System.out.println("Вы не можете создавать задачу для этого проекта");
                }

            } else {
                System.out.println("не найден проект с таким именем");
            }
        } else {
            System.out.println("Такое имя таска уже используется");
        }
    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }
}