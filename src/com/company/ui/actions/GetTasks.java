package com.company.ui.actions;

import com.company.model.Project;
import com.company.model.Task;
import com.company.service.Service;
import com.company.ui.Command;

import java.io.BufferedReader;
import java.io.IOException;

public class GetTasks implements Action {
    private Command command;
    private BufferedReader reader;
    private Service<Task> taskService;
    private Service<Project> projectService;

    public GetTasks(Command command, BufferedReader reader, Service<Task> taskService, Service<Project> projectService) {
        this.command = command;
        this.reader = reader;
        this.taskService = taskService;
        this.projectService = projectService;
    }

    @Override
    public void execute() throws IOException {
        System.out.println(taskService.getList());
    }
}
