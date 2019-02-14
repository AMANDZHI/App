package com.company.actions;

import com.company.api.Action;
import com.company.api.ServiceLocator;
import com.company.model.Project;
import com.company.model.Task;
import com.company.model.User;
import com.company.util.ActionRole;

import java.io.IOException;
import java.util.List;

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
    public boolean execute() throws IOException {
        String filePathUsers = "exportData/users.xml";
        String filePathTasks = "exportData/tasks.xml";
        String filePathProjects = "exportData/projects.xml";

        List<Project> listProjects = serviceLocator.getProjectServiceDB().getList();
        List<User> listUsers = serviceLocator.getUserServiceDB().getList();
        List<Task> listTasks = serviceLocator.getTaskServiceDB().getList();

        if (listProjects.size() != 0) {
            serviceLocator.getProjectSerializationServiceImpl().writeObjectToXml(filePathProjects, listProjects);
        }
        if (listUsers.size() != 0) {
            serviceLocator.getUserSerializationServiceImpl().writeObjectToXml(filePathUsers, listUsers);
        }
        if (listTasks.size() != 0) {
            serviceLocator.getTaskSerializationServiceImpl().writeObjectToXml(filePathTasks, listTasks);
        }
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