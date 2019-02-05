package com.company.ui.actions;

import com.company.model.Project;
import com.company.model.Task;
import com.company.ui.ServiceLocator;

import java.io.BufferedReader;
import java.io.IOException;

public class TasksGet implements Action {
    private final String command = "getListTasks";
    private final String descr = "Get list tasks";
    private BufferedReader reader;
    private ServiceLocator<Project, Task> serviceLocator;

    public TasksGet(BufferedReader reader, ServiceLocator<Project, Task> serviceLocator) {
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
        System.out.println(serviceLocator.getTaskService().getList());
    }
}
