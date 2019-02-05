package com.company.ui.actions;

import com.company.model.Project;
import com.company.model.Task;
import com.company.ui.ServiceLocator;

import java.io.BufferedReader;
import java.io.IOException;

public class ProjectUpdate implements Action {
    private final String command = "updateProject";
    private final String descr = "Update your project";
    private BufferedReader reader;
    private ServiceLocator<Project, Task> serviceLocator;

    public ProjectUpdate(BufferedReader reader, ServiceLocator<Project, Task> serviceLocator) {
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
        System.out.println("Введите id проекта");
        String answerIdProject = reader.readLine();
        System.out.println("Введите новое название проекта");
        String answerNameProject = reader.readLine();
        System.out.println("Введите новое описание проекта");
        String answerDescrProject = reader.readLine();
        Project updateProject = new Project(Integer.parseInt(answerIdProject), answerNameProject, answerDescrProject);
        serviceLocator.getProjectService().update(updateProject);
        System.out.println(updateProject);
    }
}
