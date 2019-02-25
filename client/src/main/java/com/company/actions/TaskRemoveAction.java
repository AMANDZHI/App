package com.company.actions;

import com.company.ActionRole;
import com.company.api.Session;
import com.company.api.TaskWebServiceEndpoint;
import com.company.apiClient.Action;
import com.company.service.ClientSessionService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaskRemoveAction implements Action {

    @Autowired
    private TaskWebServiceEndpoint taskWebServiceEndpoint;

    @Autowired
    private ClientSessionService clientSessionService;

    @Override
    public String getName() {
        return "removeTask";
    }

    @Override
    public String getDescription() {
        return "RemoveByName your task";
    }

    @Override
    @SneakyThrows
    public void execute() {
        String answerNameTask = CommonReader.getNameTask();

        Session session = clientSessionService.getSession();
        boolean removeTask = taskWebServiceEndpoint.removeByNameTask(answerNameTask, session);
        if (removeTask) {
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