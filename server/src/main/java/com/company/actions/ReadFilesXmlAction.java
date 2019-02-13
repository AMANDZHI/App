package com.company.actions;

import com.company.api.Action;
import com.company.api.ServiceLocator;
import com.company.model.Project;
import com.company.model.Task;
import com.company.model.User;
import com.company.util.ActionRole;
import lombok.SneakyThrows;

import java.io.IOException;
import java.util.List;

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
    @SneakyThrows
    public boolean execute() throws IOException {
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