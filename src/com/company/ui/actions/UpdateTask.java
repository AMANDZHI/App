package com.company.ui.actions;

import com.company.model.Project;
import com.company.model.Task;
import com.company.service.Service;
import com.company.ui.Command;

import java.io.BufferedReader;
import java.io.IOException;

public class UpdateTask implements Action {
    private Command command;
    private BufferedReader reader;
    private Service<Task> taskService;
    private Service<Project> projectService;

    public UpdateTask(Command command, BufferedReader reader, Service<Task> taskService, Service<Project> projectService) {
        this.command = command;
        this.reader = reader;
        this.taskService = taskService;
        this.projectService = projectService;
    }

    @Override
    public void execute() throws IOException {
        System.out.println("Введите id таска");
        String answerIdTask = reader.readLine();
        System.out.println("Введите новое название таска");
        String answerNameTask = reader.readLine();
        System.out.println("Введите новое описание таска");
        String answerDescrTask = reader.readLine();
        System.out.println("Введите новый номер id проекта");
        String answerProjectTask = reader.readLine();
        Project project = projectService.findById(Integer.parseInt(answerProjectTask));
        Task updateTask = new Task(Integer.parseInt(answerIdTask), answerNameTask, answerDescrTask, project);
        taskService.update(updateTask);
        System.out.println(updateTask);
    }
}
