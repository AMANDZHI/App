package com.company.actions;

import com.company.ActionRole;
import com.company.apiClient.Action;
import com.company.apiClient.ServiceLocatorEndpoint;
import lombok.SneakyThrows;

public class WriteAllToFilesXmlAction implements Action {
    private ServiceLocatorEndpoint serviceLocatorEndpoint;

    @Override
    public String getName() {
        return "writeAllToFileXml";
    }

    @Override
    public String getDescription() {
        return "serialization all data to xml";
    }

    @Override
    @SneakyThrows
    public void execute() {
        serviceLocatorEndpoint.getSerializationWebService().writeAllToXml();
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