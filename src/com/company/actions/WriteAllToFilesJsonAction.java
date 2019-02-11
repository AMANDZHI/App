package com.company.actions;

import com.company.api.Action;
import com.company.api.ServiceLocator;
import com.company.model.Project;
import com.company.model.Task;
import com.company.model.User;

import java.io.IOException;
import java.util.Map;

public class WriteAllToFilesJsonAction implements Action {
    private ServiceLocator serviceLocator;

    @Override
    public String getName() {
        return "writeAllToFilesJson";
    }

    @Override
    public String getDescription() {
        return "serialization all data to json";
    }

    @Override
    public void execute() throws IOException {
        String filePathUsers = "users.json";
        String filePathTasks = "tasks.json";
        String filePathProjects = "projects.json";

        Map<String, Project> mapProjects = serviceLocator.getProjectService().getRepository().getMap();
        Map<String, User> mapUsers = serviceLocator.getUserService().getRepository().getMap();
        Map<String, Task> mapTasks = serviceLocator.getTaskService().getRepository().getMap();
        if (mapProjects.size() != 0) {
            serviceLocator.getProjectSerializationServiceImpl().writeObjectToJson(filePathProjects, mapProjects);
        }
        if (mapUsers.size() != 0) {
            serviceLocator.getProjectSerializationServiceImpl().writeObjectToJson(filePathUsers, mapUsers);
        }
        if (mapTasks.size() != 0) {
            serviceLocator.getProjectSerializationServiceImpl().writeObjectToJson(filePathTasks, mapUsers);
        }
    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }
}
