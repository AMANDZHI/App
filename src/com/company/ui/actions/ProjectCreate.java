package com.company.ui.actions;

import com.company.model.Project;
import com.company.model.Task;
import com.company.ui.ServiceLocator;

import java.io.BufferedReader;
import java.io.IOException;

public class ProjectCreate implements Action {
    private final String command = "saveProject";
    private final String descr = "Save your project";
    private BufferedReader reader;
    private ServiceLocator<Project, Task> serviceLocator;

    public ProjectCreate(BufferedReader reader, ServiceLocator<Project, Task> serviceLocator) {
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
        System.out.println("Введите название проекта");
        String answerNameProject = reader.readLine();
        System.out.println("Введите описание проекта");
        String answerDescrProject = reader.readLine();
        Project newProject = new Project(Integer.parseInt(answerIdProject), answerNameProject, answerDescrProject);
        serviceLocator.getProjectService().save(newProject);
        System.out.println(newProject);
    }
}
