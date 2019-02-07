package com.company.ui.actions;

import com.company.dao.config.Session;
import com.company.model.Project;
import com.company.model.Task;
import com.company.ui.ServiceLocator;
import com.company.ui.util.CommonReader;

import java.io.IOException;

public class TaskCreateAction implements Action {
    private final ServiceLocator serviceLocator;
    private final Session session;

    public TaskCreateAction(ServiceLocator serviceLocatore, Session session) {
        this.serviceLocator = serviceLocatore;
        this.session = session;
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
            if (project.getUser().equals(session.getUser()) || session.getUser().isAdmin()) {
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