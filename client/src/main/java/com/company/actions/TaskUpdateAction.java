package com.company.actions;

import com.company.ActionRole;
import com.company.api.Session;
import com.company.api.TaskDTO;
import com.company.api.TaskWebServiceEndpoint;
import com.company.apiClient.Action;
import com.company.service.ClientSessionService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaskUpdateAction implements Action {

    @Autowired
    private TaskWebServiceEndpoint taskWebServiceEndpoint;

    @Autowired
    private ClientSessionService clientSessionService;

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
        Session session = clientSessionService.getSession();
        TaskDTO task = taskWebServiceEndpoint.updateTask(answerNameTask, answerNewNameTask, answerDescrTask, answerProjectTask, session);
        System.out.println(task);
    }

    @Override
    public ActionRole getRole() {
        return ActionRole.USER;
    }
}