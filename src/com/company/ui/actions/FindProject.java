package com.company.ui.actions;

import com.company.model.Project;
import com.company.service.Service;
import com.company.ui.Command;

import java.io.BufferedReader;
import java.io.IOException;

public class FindProject implements Action {
    private Command command;
    private BufferedReader reader;
    private Service<Project> projectService;

    public FindProject(Command command, BufferedReader reader, Service<Project> projectService) {
        this.command = command;
        this.reader = reader;
        this.projectService = projectService;
    }

    @Override
    public void execute() throws IOException {
        System.out.println("Введите id проекта");
        String answerIdProject = reader.readLine();

        Project findProject = projectService.findById(Integer.parseInt(answerIdProject));
        System.out.println(findProject);
    }
}
