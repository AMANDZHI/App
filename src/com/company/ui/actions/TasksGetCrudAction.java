package com.company.ui.actions;

import com.company.ui.ServiceLocator;

import java.io.IOException;

public class TasksGetCrudAction implements CrudAction {
    private final ServiceLocator serviceLocator;

    public TasksGetCrudAction(ServiceLocator serviceLocator) {
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
        System.out.println(serviceLocator.getTaskService().getList());
    }
}