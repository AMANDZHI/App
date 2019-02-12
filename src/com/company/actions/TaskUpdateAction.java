package com.company.actions;

import com.company.api.Action;
import com.company.api.ServiceLocator;
import com.company.model.Project;
import com.company.model.Task;

import java.io.IOException;
import java.util.Optional;

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
//        Project project = serviceLocator.getProjectService().findByName(answerProjectTask);
        Optional<Project> optionalProject = serviceLocator.getProjectServiceDB().findByName(answerProjectTask);
        Optional<Task> optionalTask = serviceLocator.getTaskServiceDB().findByName(answerNameTask);
        if (optionalProject.isPresent() && optionalTask.isPresent()) {
            if (optionalProject.get().getUser().equals(serviceLocator.getSessionService().getSession().getUser()) || serviceLocator.getSessionService().getSession().getUser().isAdmin()) {
                optionalTask.get().setName(answerNewNameTask);
                optionalTask.get().setDescription(answerDescrTask);
                optionalTask.get().setProject(optionalProject.get());
                if (serviceLocator.getTaskServiceDB().update(optionalTask.get())) {
                    System.out.println("Успешно обновлено");
                } else {
                    System.out.println("Не удалось обновить в базе");
                }
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