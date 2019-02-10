package com.company.actions;

import com.company.api.Action;
import com.company.api.ServiceLocator;

import java.io.IOException;

public class WriteAllToFilesXmlAction implements Action {
    private ServiceLocator serviceLocator;

    @Override
    public String getName() {
        return "writeAllToFilesXml";
    }

    @Override
    public String getDescription() {
        return "serialization all data";
    }

    @Override
    public void execute() throws IOException {
        String filePathUsers = "users.Xml";
        String filePathTasks = "tasks.Xml";
        String filePathProjects = "projects.Xml";

        serviceLocator.getProjectSerializationServiceImpl().writeObjectToXml(filePathProjects, serviceLocator.getProjectService().getRepository().getMap());
        serviceLocator.getProjectSerializationServiceImpl().writeObjectToXml(filePathUsers, serviceLocator.getUserService().getRepository().getMap());
        serviceLocator.getProjectSerializationServiceImpl().writeObjectToXml(filePathTasks, serviceLocator.getTaskService().getRepository().getMap());
        System.out.println("Успешно");
    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }
}