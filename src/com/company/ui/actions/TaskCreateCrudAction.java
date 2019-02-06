package com.company.ui.actions;

import com.company.model.Project;
import com.company.model.Task;
import com.company.ui.ServiceLocator;
import com.company.ui.util.CommonReader;

import java.io.IOException;

public class TaskCreateCrudAction implements CrudAction {
    private final ServiceLocator serviceLocator;

    public TaskCreateCrudAction(ServiceLocator serviceLocatore) {
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
        Task newTask = new Task(Integer.parseInt(answerIdTask), answerNameTask, answerDescrTask, project);
        serviceLocator.getTaskService().save(newTask);
        System.out.println(newTask);
    }
}