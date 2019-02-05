package com.company.ui.actions;

import com.company.model.Project;
import com.company.service.Service;
import com.company.ui.Command;

import java.io.BufferedReader;
import java.io.IOException;

public class GetProjects implements Action {
    private Command command;
    private BufferedReader reader;
    private Service<Project> projectService;

    public GetProjects(Command command, BufferedReader reader, Service<Project> projectService) {
        this.command = command;
        this.reader = reader;
        this.projectService = projectService;
    }

    @Override
    public void execute() throws IOException {
        System.out.println(projectService.getList());
    }
}
