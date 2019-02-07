package com.company.ui.actions;

import com.company.dao.config.Session;
import com.company.model.Task;
import com.company.ui.ServiceLocator;
import com.company.ui.util.CommonReader;

import java.io.IOException;

public class TaskFindAction implements Action {
    private final ServiceLocator serviceLocator;
    private final Session session;

    public TaskFindAction(ServiceLocator serviceLocator, Session session) {
        this.serviceLocator = serviceLocator;
        this.session = session;

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
        Task findTask = serviceLocator.getTaskService().findById(Integer.parseInt(answerIdTask));
        if (findTask != null) {
            if (findTask.getProject().getUser().equals(session.getUser()) || session.getUser().isAdmin()) {
                System.out.println(findTask);
            } else {
                System.out.println("Данный таск не Ваш");
            }
        } else {
            System.out.println("не найден таск с таким id");
        }
    }
}