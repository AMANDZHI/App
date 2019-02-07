package com.company.ui.actions;

import com.company.dao.config.Session;
import com.company.model.Task;
import com.company.ui.ServiceLocator;
import com.company.ui.util.CommonReader;

import java.io.IOException;

public class TaskRemoveAction implements Action {
    private final ServiceLocator serviceLocator;
    private final Session session;

    public TaskRemoveAction(ServiceLocator serviceLocator, Session session) {
        this.serviceLocator = serviceLocator;
        this.session  = session;
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
        Task task = serviceLocator.getTaskService().findById(Integer.parseInt(answerIdTask));
        if (task != null) {
            if (task.getProject().getUser().equals(session.getUser()) || session.getUser().isAdmin()) {
                serviceLocator.getTaskService().removeById(Integer.parseInt(answerIdTask));
                System.out.println("Успешно удалено");
            } else {
                System.out.println("Не имеет прав для удаления таска");
            }
        } else {
            System.out.println("не найден таск с таким id");
        }
    }
}