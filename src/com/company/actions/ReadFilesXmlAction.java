package com.company.actions;

import com.company.api.Action;
import com.company.api.ServiceLocator;
import com.company.model.Project;
import com.company.model.Task;
import com.company.model.User;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadFilesXmlAction implements Action {
    private ServiceLocator serviceLocator;

    @Override
    public String getName() {
        return "readFilesXmlToAllRepo";
    }

    @Override
    public String getDescription() {
        return "deserialization files Xml data to objects";
    }

    @Override
    public void execute() throws IOException {
        String filePathUsers = "users.Xml";
        String filePathTasks = "tasks.Xml";
        String filePathProjects = "projects.Xml";

        List<Project> listProjects = serviceLocator.getProjectSerializationServiceImpl().readXmlToObject(filePathProjects);
        List<User> listUsers = serviceLocator.getUserSerializationServiceImpl().readXmlToObject(filePathUsers);
        List<Task> listTasks = serviceLocator.getTaskSerializationServiceImpl().readXmlToObject(filePathTasks);

        for (User u: listUsers) {
            if (!serviceLocator.getUserServiceDB().findByLogin(u.getLogin()).isPresent()) {
                serviceLocator.getUserServiceDB().save(u);
            }
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