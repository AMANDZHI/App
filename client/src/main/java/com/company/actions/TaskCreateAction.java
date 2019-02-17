package com.company.actions;

import com.company.ActionRole;
import com.company.apiClient.Action;
import com.company.apiClient.ServiceLocatorEndpoint;
import com.company.api.Project;
import com.company.api.Session;
import com.company.api.Task;
import lombok.SneakyThrows;

public class TaskCreateAction implements Action {
    private ServiceLocatorEndpoint serviceLocatorEndpoint;

    @Override
    public String getName() {
        return "saveTask";
    }

    @Override
    public String getDescription() {
        return "Save your task";
    }

    @Override
    @SneakyThrows
    public void execute() {
        String answerNameTask = CommonReader.getNameTask();
        String answerDescrTask = CommonReader.getDescrTask();
        String answerProjectTask = CommonReader.getNameProject();

        Session session = serviceLocatorEndpoint.getClientSessionService().getSession();
        Task task = new Task();
        task.setName(answerNameTask);
        task.setDescription(answerDescrTask);
        Project project = serviceLocatorEndpoint.getProjectWebService().findByNameProject(answerProjectTask, session);
        if (project != null) {
            task.setProject(project);
            boolean answerSave = serviceLocatorEndpoint.getTaskWebService().saveTask(task, session);
            if (answerSave) {
                System.out.println("Успещно");
            } else {
                System.out.println("Неудачно");
            }
        } else {
            System.out.println("Не найден такой проект");
        }
    }

    @Override
    public void setServiceLocatorEndpoint(ServiceLocatorEndpoint serviceLocatorEndpoint) {
        this.serviceLocatorEndpoint = serviceLocatorEndpoint;
    }

    @Override
    public ActionRole getRole() {
        return ActionRole.USER;
    }
}