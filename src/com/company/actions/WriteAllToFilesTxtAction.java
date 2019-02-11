package com.company.actions;

import com.company.api.Action;
import com.company.api.ServiceLocator;
import com.company.model.Project;
import com.company.model.Task;
import com.company.model.User;

import java.io.IOException;
import java.util.Map;

public class WriteAllToFilesTxtAction implements Action {
    private ServiceLocator serviceLocator;

    @Override
    public String getName() {
        return "writeAllToFilesTxt";
    }

    @Override
    public String getDescription() {
        return "serialization all data to txt";
    }

    @Override
    public void execute() throws IOException {
        String filePathUsers = "users.txt";
        String filePathTasks = "tasks.txt";
        String filePathProjects = "projects.txt";

        Map<String, Project> mapProjects = serviceLocator.getProjectService().getRepository().getMap();
        Map<String, User> mapUsers = serviceLocator.getUserService().getRepository().getMap();
        Map<String, Task> mapTasks = serviceLocator.getTaskService().getRepository().getMap();

        if (mapProjects.size() != 0) {
            serviceLocator.getProjectSerializationServiceImpl().writeObjectToFile(filePathProjects, mapProjects);
        }
        if (mapUsers.size() != 0) {
            serviceLocator.getProjectSerializationServiceImpl().writeObjectToFile(filePathUsers, mapUsers);
        }
        if (mapTasks.size() != 0) {
            serviceLocator.getProjectSerializationServiceImpl().writeObjectToFile(filePathTasks, mapUsers);
        }
    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }
}
