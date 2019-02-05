package com.company.ui.actions;

import com.company.model.Project;
import com.company.model.Task;
import com.company.ui.ServiceLocator;

import java.io.BufferedReader;
import java.io.IOException;

public class ProjectFind implements Action {
    private final String command = "findProject";
    private final String descr =  "FindById your project";
    private BufferedReader reader;
    private ServiceLocator<Project, Task> serviceLocator;

    public ProjectFind(BufferedReader reader, ServiceLocator<Project, Task> serviceLocator) {
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

        Project findProject = serviceLocator.getProjectService().findById(Integer.parseInt(answerIdProject));
        System.out.println(findProject);
    }
}
