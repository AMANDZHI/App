package com.company.actions;

import com.company.ActionRole;
import com.company.api.*;
import com.company.apiClient.Action;
import com.company.service.ClientSessionService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaskCreateAction implements Action {

    @Autowired
    private TaskWebServiceEndpoint taskWebServiceEndpoint;

    @Autowired
    private ClientSessionService clientSessionService;

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

        Session session = clientSessionService.getSession();
        TaskDTO saveTask = taskWebServiceEndpoint.saveTask(answerNameTask, answerDescrTask, answerProjectTask, session);
        if (saveTask != null) {
            System.out.println("Готово");
        } else {
            System.out.println("Неудачно");
        }
    }

    @Override
    public ActionRole getRole() {
        return ActionRole.USER;
    }
}