package com.company.actions;

import com.company.api.Action;
import com.company.api.ServiceLocator;
import com.company.model.Task;
import com.company.util.Role;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TaskListAction implements Action {
    private ServiceLocator serviceLocator;

    @Override
    public String getName() {
        return "getListTasks";
    }

    @Override
    public String getDescription() {
        return "Get list tasks";
    }

    @Override
    public boolean execute() throws IOException {
        List<Task> yourTasks = new ArrayList<>();
        List<Task> list = serviceLocator.getTaskServiceDB().getList();
        for (Task task: list) {
            if (task.getProject().getUser().equals(serviceLocator.getSessionService().getSession().getUser()) || serviceLocator.getSessionService().getSession().getUser().isAdmin()) {
                yourTasks.add(task);
            }
        }
        System.out.println(yourTasks);
        return true;
    }

    @Override
    public Role getRole() {
        return Role.USER;
    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }
}