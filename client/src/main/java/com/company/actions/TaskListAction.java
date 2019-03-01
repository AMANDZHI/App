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

import java.util.List;

@Component
public class TaskListAction implements Action {
    @Autowired
    private TaskWebServiceEndpoint taskWebServiceEndpoint;

    @Autowired
    private ClientSessionService clientSessionService;

    @Override
    public String getName() {
        return "getListTasks";
    }

    @Override
    public String getDescription() {
        return "Get list tasks";
    }

    @Override
    @SneakyThrows
    public void execute() {
        Session session = clientSessionService.getSession();
        List<TaskDTO> list = taskWebServiceEndpoint.getListTask(session);
        System.out.println(list);
    }

    @Override
    public ActionRole getRole() {
        return ActionRole.USER;
    }
}