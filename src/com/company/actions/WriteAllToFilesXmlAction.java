package com.company.actions;

import com.company.api.Action;
import com.company.api.ServiceLocator;
import com.company.model.Project;
import com.company.model.Task;
import com.company.model.User;

import java.io.IOException;
import java.util.Map;

public class WriteAllToFilesXmlAction implements Action {
    private ServiceLocator serviceLocator;

    @Override
    public String getName() {
        return "writeAllToFilesXml";
    }

    @Override
    public String getDescription() {
        return "serialization all data to xml";
    }

    @Override
    public void execute() throws IOException {
        String filePathUsers = "users.xml";
        String filePathTasks = "tasks.xml";
        String filePathProjects = "projects.xml";

        Map<String, Project> mapProjects = serviceLocator.getProjectService().getRepository().getMap();
        Map<String, User> mapUsers = serviceLocator.getUserService().getRepository().getMap();
        Map<String, Task> mapTasks = serviceLocator.getTaskService().getRepository().getMap();

        if (mapProjects.size() != 0) {
            serviceLocator.getProjectSerializationServiceImpl().writeObjectToXml(filePathProjects, mapProjects);
        }
        if (mapUsers.size() != 0) {
            serviceLocator.getProjectSerializationServiceImpl().writeObjectToXml(filePathUsers, mapUsers);
        }
        if (mapTasks.size() != 0) {
            serviceLocator.getProjectSerializationServiceImpl().writeObjectToXml(filePathTasks, mapUsers);
        }
    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }
}