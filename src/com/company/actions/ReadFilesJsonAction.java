package com.company.actions;

import com.company.api.Action;
import com.company.api.ServiceLocator;
import com.company.model.Project;
import com.company.model.Task;
import com.company.model.User;

import java.io.IOException;
import java.util.List;

public class ReadFilesJsonAction implements Action {
    private ServiceLocator serviceLocator;

    @Override
    public String getName() {
        return "readFilesJsonToAllRepo";
    }

    @Override
    public String getDescription() {
        return "deserialization files json data to objects";
    }

    @Override
    public void execute() throws IOException {
        String filePathUsers = "users.json";
        String filePathTasks = "tasks.json";
        String filePathProjects = "projects.json";

        List<Project> listProjects = serviceLocator.getProjectSerializationServiceImpl().readJsonToObject(filePathProjects);
        List<User> listUsers = serviceLocator.getUserSerializationServiceImpl().readJsonToObject(filePathUsers);
        List<Task> listTasks = serviceLocator.getTaskSerializationServiceImpl().readJsonToObject(filePathTasks);

        for (User u: listUsers) {
            serviceLocator.getUserServiceDB().save(u);
        }

        for (Project p: listProjects) {
            serviceLocator.getProjectServiceDB().save(p);
        }

        for (Task t: listTasks) {
            serviceLocator.getTaskServiceDB().save(t);
        }

        System.out.println("Успешно");
    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }
}