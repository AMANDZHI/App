package com.company.ui.actions;

import com.company.model.Task;
import com.company.ui.ServiceLocator;
import com.company.ui.util.CommonReader;

import java.io.IOException;

public class TaskFindCrudAction implements CrudAction {
    private final ServiceLocator serviceLocator;

    public TaskFindCrudAction(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    @Override
    public String getName() {
        return "findTask";
    }

    @Override
    public String getDescription() {
        return "FindById your task";
    }

    @Override
    public void execute() throws IOException {
        String answerIdTask = CommonReader.getIdTask();
        Task findTask = serviceLocator.getTaskService().findById(Integer.parseInt(answerIdTask)-1);
        System.out.println(findTask);
    }
}