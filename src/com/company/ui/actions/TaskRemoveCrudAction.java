package com.company.ui.actions;

import com.company.ui.ServiceLocator;
import com.company.ui.util.CommonReader;

import java.io.BufferedReader;
import java.io.IOException;

public class TaskRemoveCrudAction implements CrudAction {
    private final BufferedReader reader;
    private final ServiceLocator serviceLocator;

    public TaskRemoveCrudAction(BufferedReader reader, ServiceLocator serviceLocator) {
        this.reader = reader;
        this.serviceLocator = serviceLocator;
    }

    @Override
    public String getName() {
        return "removeTask";
    }

    @Override
    public String getDescription() {
        return "RemoveById your task";
    }

    @Override
    public void execute() throws IOException {
        String answerIdTask = CommonReader.getIdTask();
        serviceLocator.getTaskService().removeById(Integer.parseInt(answerIdTask)-1);
        System.out.println("Удалено");
    }
}