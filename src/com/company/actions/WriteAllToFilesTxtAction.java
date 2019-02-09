package com.company.actions;

import com.company.api.Action;
import com.company.api.ServiceLocator;

import java.io.IOException;

public class WriteAllToFilesTxtAction implements Action {
    private ServiceLocator serviceLocator;

    @Override
    public String getName() {
        return "writeAllToFilesTxt";
    }

    @Override
    public String getDescription() {
        return "serialization all data";
    }

    @Override
    public void execute() throws IOException {
        String filePathUsers = "users.txt";
        String filePathTasks = "tasks.txt";
        String filePathProjects = "projects.txt";

        serviceLocator.getProjectSerializationServiceImpl().writeObjectToFile(filePathProjects, serviceLocator.getProjectService().getRepository().getMap());
        serviceLocator.getProjectSerializationServiceImpl().writeObjectToFile(filePathUsers, serviceLocator.getUserService().getRepository().getMap());
        serviceLocator.getProjectSerializationServiceImpl().writeObjectToFile(filePathTasks, serviceLocator.getTaskService().getRepository().getMap());
        System.out.println("Успешно");
    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }
}
