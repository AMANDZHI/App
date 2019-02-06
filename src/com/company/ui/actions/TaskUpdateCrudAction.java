package com.company.ui.actions;

import com.company.model.Project;
import com.company.model.Task;
import com.company.ui.ServiceLocator;
import com.company.ui.util.CommonReader;

import java.io.BufferedReader;
import java.io.IOException;

public class TaskUpdateCrudAction implements CrudAction {
    private final BufferedReader reader;
    private final ServiceLocator serviceLocator;

    public TaskUpdateCrudAction(BufferedReader reader, ServiceLocator serviceLocator) {
        this.reader = reader;
        this.serviceLocator = serviceLocator;
    }

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
        String answerIdTask = CommonReader.getIdTask();
        String answerNameTask = CommonReader.getNewNameTask();;
        String answerDescrTask = CommonReader.getNewDescrTask();
        String answerProjectTask = CommonReader.getNewProjectTask();
        Project project = serviceLocator.getProjectService().findById(Integer.parseInt(answerProjectTask));
        Task updateTask = new Task(Integer.parseInt(answerIdTask), answerNameTask, answerDescrTask, project);
        serviceLocator.getTaskService().update(updateTask);
        System.out.println(updateTask);
    }
}