package com.company.actions;

import com.company.ActionRole;
import com.company.apiClient.Action;
import com.company.apiClient.ServiceLocatorEndpoint;

public class WriteAllToFilesJsonAction implements Action {
    private ServiceLocatorEndpoint serviceLocatorEndpoint;

    @Override
    public String getName() {
        return "writeAllToFileJson";
    }

    @Override
    public String getDescription() {
        return "serialization all data to json";
    }

    @Override
    public void execute() {
        serviceLocatorEndpoint.getSerializationWebService().writeAllToJson();
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