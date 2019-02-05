package com.company;

import com.company.dao.repository.ProjectRepository;
import com.company.dao.repository.Repository;
import com.company.dao.repository.TaskRepository;
import com.company.model.Project;
import com.company.model.Task;
import com.company.service.ProjectServiceImpl;
import com.company.service.Service;
import com.company.service.TaskServiceImpl;
import com.company.ui.Command;
import com.company.ui.Menu;
import com.company.ui.actions.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Initializer {
    private final Repository projectRepository = new ProjectRepository();
    private final Repository taskRepository = new TaskRepository();
    private final Service<Project> projectService = new ProjectServiceImpl(projectRepository, taskRepository);
    private final Service<Task> taskService = new TaskServiceImpl(taskRepository);
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final Command goToProjectCommand = new Command("goToProject");
    private final Command goToTaskCommand = new Command("goToTask");
    private final Command saveProjectCommand = new Command("saveProject");
    private final Command findProjectCommand = new Command("findProject");
    private final Command updateProjectCommand =  new Command("updateProject");
    private final Command removeProjectCommand = new Command("removeProject");
    private final Command getListProjectsCommand = new Command("getListProjects");
    private final Command saveTaskCommand = new Command("saveTask");
    private final Command findTaskCommand = new Command("findTask");
    private final Command updateTaskCommand =  new Command("updateTask");
    private final Command removeTaskCommand = new Command("removeTask");
    private final Command getListTasksCommand = new Command("getListTasks");
    private List<Command> listStart = new ArrayList<>();
    private List<Command> listActionTask = new ArrayList<>();
    private List<Command> listActionProject = new ArrayList<>();;
    private final Action saveProject = new CreateProject(saveProjectCommand, reader, projectService);
    private final Action findProject = new FindProject(findProjectCommand, reader, projectService);
    private final Action updateProject = new UpdateProject(updateProjectCommand, reader, projectService);
    private final Action removeProject = new RemoveProject(removeProjectCommand, reader, projectService);
    private final Action getListProjects = new GetProjects(getListProjectsCommand, reader, projectService);
    private final Action saveTask = new CreateTask(saveProjectCommand, reader, taskService, projectService);
    private final Action findTask = new FindTask(findProjectCommand, reader, taskService, projectService);
    private final Action updateTask = new CreateTask(updateTaskCommand, reader, taskService, projectService);
    private final Action removeTask = new CreateTask(removeTaskCommand, reader, taskService, projectService);
    private final Action getListTasks = new CreateTask(getListTasksCommand, reader, taskService, projectService);
    private final HashMap<Command, Action> map = new HashMap<>();

    {
        listStart.add(goToProjectCommand);
        listStart.add(goToTaskCommand);

        listActionProject.add(saveProjectCommand);
        listActionProject.add(findProjectCommand);
        listActionProject.add(updateProjectCommand);
        listActionProject.add(removeProjectCommand);
        listActionProject.add(getListProjectsCommand);


        listActionTask.add(saveTaskCommand);
        listActionTask.add(findTaskCommand);
        listActionTask.add(updateTaskCommand);
        listActionTask.add(removeTaskCommand);
        listActionTask.add(getListTasksCommand);

        map.put(saveProjectCommand, saveProject);
        map.put(findProjectCommand, findProject);
        map.put(updateProjectCommand, updateProject);
        map.put(removeProjectCommand, removeProject);
        map.put(getListProjectsCommand, getListProjects);
        map.put(saveTaskCommand, saveTask);
        map.put(findTaskCommand, findTask);
        map.put(updateTaskCommand, updateTask);
        map.put(removeTaskCommand, removeTask);
        map.put(getListTasksCommand, getListTasks);
    }

    public void run() throws IOException {
        Menu menu = new Menu(listStart, listActionProject, listActionTask, reader, map);
        menu.startMenu();
    }
}
