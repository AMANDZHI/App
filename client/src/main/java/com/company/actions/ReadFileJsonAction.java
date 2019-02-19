package com.company.actions;

import com.company.ActionRole;
import com.company.apiClient.Action;
import com.company.apiClient.ServiceLocatorEndpoint;
import lombok.SneakyThrows;

public class ReadFileJsonAction implements Action {
    private ServiceLocatorEndpoint serviceLocatorEndpoint;

    @Override
    public String getName() {
        return "readFileJsonToAllRepo";
    }

    @Override
    public String getDescription() {
        return "deserialization file json data to objects";
    }

    @Override
    @SneakyThrows
    public void execute() {
        serviceLocatorEndpoint.getSerializationWebService().readJsonToObjects();
        System.out.println("Готово");
    }

    @Override
    public void setServiceLocatorEndpoint(ServiceLocatorEndpoint serviceLocatorEndpoint) {
        this.serviceLocatorEndpoint = serviceLocatorEndpoint;
    }

    @Override
    public ActionRole getRole() {
        return ActionRole.ADMIN;
    }
}