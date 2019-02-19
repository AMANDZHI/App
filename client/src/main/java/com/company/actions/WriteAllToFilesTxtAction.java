package com.company.actions;

import com.company.ActionRole;
import com.company.apiClient.Action;
import com.company.apiClient.ServiceLocatorEndpoint;
import lombok.SneakyThrows;

public class WriteAllToFilesTxtAction implements Action {
    private ServiceLocatorEndpoint serviceLocatorEndpoint;

    @Override
    public String getName() {
        return "writeAllToFilesTxt";
    }

    @Override
    public String getDescription() {
        return "serialization all data to txt";
    }

    @Override
    @SneakyThrows
    public void execute() {
        serviceLocatorEndpoint.getSerializationWebService().writeObjectsToFiles();
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