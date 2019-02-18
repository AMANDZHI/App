package com.company.actions;

import com.company.ActionRole;
import com.company.api.TaskWebServiceEndpoint;
import com.company.apiClient.Action;
import com.company.apiClient.ServiceLocatorEndpoint;
import com.company.api.Session;
import com.company.api.Task;
import lombok.SneakyThrows;

import java.util.List;

public class TaskListAction implements Action {
    private ServiceLocatorEndpoint serviceLocatorEndpoint;

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
        Session session = serviceLocatorEndpoint.getClientSessionService().getSession();
        TaskWebServiceEndpoint taskWebService = serviceLocatorEndpoint.getTaskWebService();
        List<Task> list = taskWebService.getListTask(session);
        System.out.println(list);
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