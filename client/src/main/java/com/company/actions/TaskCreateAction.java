package com.company.actions;

import com.company.ActionRole;
import com.company.api.*;
import com.company.apiClient.Action;
import com.company.apiClient.ServiceLocatorEndpoint;
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
        ProjectWebServiceEndpoint projectWebService = serviceLocatorEndpoint.getProjectWebService();
        Project project = projectWebService.findByNameProject(answerProjectTask, session);
        if (project != null) {
            Task task = new Task();
            task.setName(answerNameTask);
            task.setDescription(answerDescrTask);
            task.setProject(project);
            User findUser = serviceLocatorEndpoint.getUserWebService().findByIdUser(session.getUserId(), session);
            task.setUser(findUser);
            serviceLocatorEndpoint.getTaskWebService().saveTask(task, session);
            System.out.println("Готово");
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