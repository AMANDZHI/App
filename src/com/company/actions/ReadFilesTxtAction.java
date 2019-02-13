package com.company.actions;

import com.company.api.Action;
import com.company.api.ServiceLocator;
import com.company.model.Project;
import com.company.model.Task;
import com.company.model.User;
import com.company.util.ActionRole;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ReadFilesTxtAction implements Action {
    private ServiceLocator serviceLocator;

    @Override
    public String getName() {
        return "readFilesTxtToAllRepo";
    }

    @Override
    public String getDescription() {
        return "deserialization txt data to objects";
    }

    @Override
    public boolean execute() throws IOException, SQLException {
        String filePathUsers = "users.txt";
        String filePathTasks = "tasks.txt";
        String filePathProjects = "projects.txt";

        List<Project> listProjects = serviceLocator.getProjectSerializationServiceImpl().readFileToObject(filePathProjects);
        List<User> listUsers = serviceLocator.getUserSerializationServiceImpl().readFileToObject(filePathUsers);
        List<Task> listTasks = serviceLocator.getTaskSerializationServiceImpl().readFileToObject(filePathTasks);

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
    public ActionRole getRole() {
        return ActionRole.ADMIN;
    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }
}
