package com.company.actions;

import com.company.ActionRole;
import com.company.apiClient.Action;
import com.company.apiClient.ServiceLocatorEndpoint;
import com.company.api.Project;
import com.company.api.Session;
import com.company.api.Task;
import lombok.SneakyThrows;

public class TaskUpdateAction implements Action {
    private ServiceLocatorEndpoint serviceLocatorEndpoint;

    @Override
    public String getName() {
        return "updateTask";
    }

    @Override
    public String getDescription() {
        return "Update your task";
    }

    @Override
    @SneakyThrows
    public void execute() {
        String answerNameTask = CommonReader.getNameTask();
        String answerNewNameTask = CommonReader.getNewNameTask();
        String answerDescrTask = CommonReader.getNewDescrTask();
        String answerProjectTask = CommonReader.getNewNameProjectTask();
        Session session = serviceLocatorEndpoint.getClientSessionService().getSession();
        Project findProject = serviceLocatorEndpoint.getProjectWebService().findByNameProject(answerProjectTask, session);
        Task updateTask = serviceLocatorEndpoint.getTaskWebService().findByNameTask(answerNameTask, session);

        if (findProject != null && updateTask != null) {
            updateTask.setName(answerNewNameTask);
            updateTask.setDescription(answerDescrTask);
            updateTask.setProject(findProject);
            boolean answerUpdate = serviceLocatorEndpoint.getTaskWebService().updateTask(updateTask, session);
            if (answerUpdate) {
                System.out.println("Успешно");
            } else {
                System.out.println("Неудачно");
            }
        } else {
            System.out.println("Неудачно");
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