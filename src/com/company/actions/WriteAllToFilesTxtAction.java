package com.company.actions;

import com.company.api.Action;
import com.company.api.ServiceLocator;
import com.company.model.Project;
import com.company.model.Task;
import com.company.model.User;
import com.company.util.Role;

import java.io.IOException;
import java.util.List;

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

        List<Project> listProjects = serviceLocator.getProjectServiceDB().getList();
        List<User> listUsers = serviceLocator.getUserServiceDB().getList();
        List<Task> listTasks = serviceLocator.getTaskServiceDB().getList();

        if (listProjects.size() != 0) {
            serviceLocator.getProjectSerializationServiceImpl().writeObjectToFile(filePathProjects, listProjects);
        }
        if (listUsers.size() != 0) {
            serviceLocator.getUserSerializationServiceImpl().writeObjectToFile(filePathUsers, listUsers);
        }
        if (listTasks.size() != 0) {
            serviceLocator.getTaskSerializationServiceImpl().writeObjectToFile(filePathTasks, listUsers);
        }
    }

    @Override
    public Role getRole() {
        return Role.ADMIN;
    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }
}
