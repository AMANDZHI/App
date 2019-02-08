package com.company.actions;

import com.company.api.Action;
import com.company.model.Task;
import com.company.api.ServiceLocator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    public void execute() throws IOException {
        List<Task> yourTasks = new ArrayList<>();
        Map<String, Task> map = serviceLocator.getTaskService().getMap();
        for (Map.Entry<String, Task> pair: map.entrySet()) {
            if (pair.getValue().getProject().getUser().equals(serviceLocator.getSessionService().getSession().getUser()) || serviceLocator.getSessionService().getSession().getUser().isAdmin()) {
                yourTasks.add(pair.getValue());
            }
        }
        System.out.println(yourTasks);
    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }
}