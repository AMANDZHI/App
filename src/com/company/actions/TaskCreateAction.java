package com.company.actions;

import com.company.api.Action;
import com.company.model.Project;
import com.company.model.Task;
import com.company.api.ServiceLocator;

import java.io.IOException;

public class TaskCreateAction implements Action {
    private final ServiceLocator serviceLocator;

    public TaskCreateAction(ServiceLocator serviceLocatore) {
        this.serviceLocator = serviceLocatore;
    }

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
        String answerIdTask = CommonReader.getIdTask();
        String answerNameTask = CommonReader.getNameTask();
        String answerDescrTask = CommonReader.getDescrTask();
        String answerProjectTask = CommonReader.getIdProject();
        Project project = serviceLocator.getProjectService().findById(Integer.parseInt(answerProjectTask));
        if (project != null) {
            if (project.getUser().equals(serviceLocator.getSessionService().getSession().getUser()) || serviceLocator.getSessionService().getSession().getUser().isAdmin()) {
                Task newTask = new Task(Integer.parseInt(answerIdTask), answerNameTask, answerDescrTask, project);
                serviceLocator.getTaskService().save(newTask);
                System.out.println(newTask);
            } else {
                System.out.println("Вы не можете создавать задачу для этого проекта");
            }

        } else {
            System.out.println("не найден проект с таким id");
        }

    }
}