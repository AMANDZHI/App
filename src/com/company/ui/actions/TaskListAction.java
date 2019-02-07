package com.company.ui.actions;

import com.company.dao.config.Session;
import com.company.model.Task;
import com.company.ui.ServiceLocator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TaskListAction implements Action {
    private final ServiceLocator serviceLocator;
    private final Session session;

    public TaskListAction(ServiceLocator serviceLocator, Session session) {
        this.serviceLocator = serviceLocator;
        this.session = session;
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
            if (t.getProject().getUser().equals(session.getUser()) || session.getUser().isAdmin()) {
                yourTasks.add(t);
            }
        }
        System.out.println(yourTasks);
    }
}