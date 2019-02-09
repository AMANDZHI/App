package com.company.actions;

import com.company.api.Action;
import com.company.api.ServiceLocator;

import java.io.IOException;

public class WriteAllToFilesJsonAction implements Action {
    private ServiceLocator serviceLocator;

    @Override
    public String getName() {
        return "writeAllToFilesJson";
    }

    @Override
    public String getDescription() {
        return "serialization all data";
    }

    @Override
    public void execute() throws IOException {
        String filePathUsers = "users.json";
        String filePathTasks = "tasks.json";
        String filePathProjects = "projects.json";

        serviceLocator.getProjectSerializationServiceImpl().writeObjectToJson(filePathProjects, serviceLocator.getProjectService().getRepository().getMap());
        serviceLocator.getProjectSerializationServiceImpl().writeObjectToJson(filePathUsers, serviceLocator.getUserService().getRepository().getMap());
        serviceLocator.getProjectSerializationServiceImpl().writeObjectToJson(filePathTasks, serviceLocator.getTaskService().getRepository().getMap());
        System.out.println("Успешно");
    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }
}
