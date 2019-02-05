package com.company.ui.actions;

import com.company.model.Project;
import com.company.model.Task;
import com.company.ui.ServiceLocator;

import java.io.BufferedReader;
import java.io.IOException;

public class TaskCreate implements Action {
    private final String command = "saveTask";
    private final String descr = "Save your task";
    private BufferedReader reader;
    private ServiceLocator<Project, Task> serviceLocator;

    public TaskCreate( BufferedReader reader, ServiceLocator<Project, Task> serviceLocatore) {
        this.reader = reader;
        this.serviceLocator = serviceLocatore;
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
        System.out.println("Введите название таска");
        String answerNameTask = reader.readLine();
        System.out.println("Введите описание таска");
        String answerDescrTask = reader.readLine();
        System.out.println("Введите номер id проекта");
        String answerProjectTask = reader.readLine();
        Project project = serviceLocator.getProjectService().findById(Integer.parseInt(answerProjectTask));
        Task newTask = new Task(Integer.parseInt(answerIdTask), answerNameTask, answerDescrTask, project);
        serviceLocator.getTaskService().save(newTask);
        System.out.println(newTask);
    }
}
