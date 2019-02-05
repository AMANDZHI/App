package com.company.ui.actions;

import com.company.model.Project;
import com.company.service.Service;
import com.company.ui.Command;

import java.io.BufferedReader;
import java.io.IOException;

public class UpdateProject implements Action {
    private Command command;
    private BufferedReader reader;
    private Service<Project> projectService;

    public UpdateProject(Command command, BufferedReader reader, Service<Project> projectService) {
        this.command = command;
        this.reader = reader;
        this.projectService = projectService;
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
        projectService.update(updateProject);
        System.out.println(updateProject);
    }
}
