package com.company.actions;

import com.company.api.Action;
import com.company.model.Task;
import com.company.api.ServiceLocator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TaskListAction implements Action {
    private final ServiceLocator serviceLocator;

    public TaskListAction(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    @Override
    public String getName() {
        return "getListTasks";
    }

    @Override
    public String getDescription() {
        return "Get list tasks";
    }

    @Override
    public void execute() throws IOException {
        List<Task> yourTasks = new ArrayList<>();
        List<Task> list = serviceLocator.getTaskService().getList();
        for (Task t: list) {
            if (t.getProject().getUser().equals(serviceLocator.getSessionService().getSession().getUser()) || serviceLocator.getSessionService().getSession().getUser().isAdmin()) {
                yourTasks.add(t);
            }
        }
        System.out.println(yourTasks);
    }
}