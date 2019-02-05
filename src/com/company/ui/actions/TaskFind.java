package com.company.ui.actions;

import com.company.model.Project;
import com.company.model.Task;
import com.company.ui.ServiceLocator;

import java.io.BufferedReader;
import java.io.IOException;

public class TaskFind implements Action {
    private final String command = "findTask";
    private final String descr = "FindById your task";
    private BufferedReader reader;
    private ServiceLocator<Project, Task> serviceLocator;

    public TaskFind(BufferedReader reader, ServiceLocator<Project, Task> serviceLocator) {
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
        Task findTask = serviceLocator.getTaskService().findById(Integer.parseInt(answerIdTask));
        System.out.println(findTask);
    }
}
