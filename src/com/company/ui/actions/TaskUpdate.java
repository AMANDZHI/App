package com.company.ui.actions;

import com.company.model.Project;
import com.company.model.Task;
import com.company.ui.ServiceLocator;

import java.io.BufferedReader;
import java.io.IOException;

public class TaskUpdate implements Action {
    private final String command = "updateTask";
    private final String descr = "Update your task";
    private BufferedReader reader;
    private ServiceLocator<Project, Task> serviceLocator;

    public TaskUpdate(BufferedReader reader, ServiceLocator<Project, Task> serviceLocator) {
        this.reader = reader;
        this.serviceLocator = serviceLocator;
    }

    @Override
    public String getName() {
        return command;
    }

    @Override
    public String getDescription() {
        return descr;
    }

    @Override
    public void execute() throws IOException {
        System.out.println("Введите id таска");
        String answerIdTask = reader.readLine();
        System.out.println("Введите новое название таска");
        String answerNameTask = reader.readLine();
        System.out.println("Введите новое описание таска");
        String answerDescrTask = reader.readLine();
        System.out.println("Введите новый номер id проекта");
        String answerProjectTask = reader.readLine();
        Project project = serviceLocator.getProjectService().findById(Integer.parseInt(answerProjectTask));
        Task updateTask = new Task(Integer.parseInt(answerIdTask), answerNameTask, answerDescrTask, project);
        serviceLocator.getTaskService().update(updateTask);
        System.out.println(updateTask);
    }
}