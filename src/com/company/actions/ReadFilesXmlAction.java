package com.company.actions;

import com.company.api.Action;
import com.company.api.ServiceLocator;
import com.company.model.Project;
import com.company.model.Task;
import com.company.model.User;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadFilesXmlAction implements Action {
    private ServiceLocator serviceLocator;

    @Override
    public String getName() {
        return "readFilesXmlToAllRepo";
    }

    @Override
    public String getDescription() {
        return "deserialization files Xml data to objects";
    }

    @Override
    public void execute() throws IOException {
        String filePathUsers = "users.Xml";
        String filePathTasks = "tasks.Xml";
        String filePathProjects = "projects.Xml";

        Map<String, Project> mapProjects = new HashMap<>();
        Map<String, User> mapUsers = new HashMap<>();
        Map<String, Task> mapTasks = new HashMap<>();

        mapProjects = serviceLocator.getProjectSerializationServiceImpl().readXmlToObject(filePathProjects);
        mapUsers = serviceLocator.getUserSerializationServiceImpl().readXmlToObject(filePathUsers);
        mapTasks = serviceLocator.getTaskSerializationServiceImpl().readXmlToObject(filePathTasks);
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