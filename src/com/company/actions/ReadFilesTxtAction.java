package com.company.actions;

import com.company.api.Action;
import com.company.api.ServiceLocator;
import com.company.model.Project;
import com.company.model.Task;
import com.company.model.User;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadFilesTxtAction implements Action {
    private ServiceLocator serviceLocator;

    @Override
    public String getName() {
        return "readFilesTxtToAllRepo";
    }

    @Override
    public String getDescription() {
        return "deserialization txt data to objects";
    }

    @Override
    public void execute() throws IOException {
        String filePathUsers = "users.txt";
        String filePathTasks = "tasks.txt";
        String filePathProjects = "projects.txt";

        Map<String, Project> mapProjects = new HashMap<>();
        Map<String, User> mapUsers = new HashMap<>();
        Map<String, Task> mapTasks = new HashMap<>();

        mapProjects = serviceLocator.getProjectSerializationServiceImpl().readFileToObject(filePathProjects);
        mapUsers = serviceLocator.getUserSerializationServiceImpl().readFileToObject(filePathUsers);
        mapTasks = serviceLocator.getTaskSerializationServiceImpl().readFileToObject(filePathTasks);
        serviceLocator.getProjectService().getRepository().setMap(mapProjects);
        serviceLocator.getUserService().getRepository().setMap(mapUsers);
        serviceLocator.getTaskService().getRepository().setMap(mapTasks);
        System.out.println("Успешно");
    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }
}
