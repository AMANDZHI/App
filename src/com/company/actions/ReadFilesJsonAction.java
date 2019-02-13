package com.company.actions;

import com.company.api.Action;
import com.company.api.ServiceLocator;
import com.company.model.Project;
import com.company.model.Task;
import com.company.model.User;
import com.company.util.Role;

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
    public boolean execute() throws IOException {
        String filePathUsers = "users.json";
        String filePathTasks = "tasks.json";
        String filePathProjects = "projects.json";

        List<Project> listProjects = serviceLocator.getProjectSerializationServiceImpl().readJsonToObject(filePathProjects);
        List<User> listUsers = serviceLocator.getUserSerializationServiceImpl().readJsonToObject(filePathUsers);
        List<Task> listTasks = serviceLocator.getTaskSerializationServiceImpl().readJsonToObject(filePathTasks);

        for (User u: listUsers) {
            if (!serviceLocator.getUserServiceDB().findByLogin(u.getLogin()).isPresent()) {
                serviceLocator.getUserServiceDB().save(u);
            }
        }

        for (Project p: listProjects) {
            if (!serviceLocator.getProjectServiceDB().findById(p.getId()).isPresent()) {
                serviceLocator.getProjectServiceDB().save(p);
            }
        }

        for (Task t: listTasks) {
            if (!serviceLocator.getTaskServiceDB().findById(t.getId()).isPresent()) {
                serviceLocator.getTaskServiceDB().save(t);
            }
        }

        System.out.println("Успешно");
        return true;
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