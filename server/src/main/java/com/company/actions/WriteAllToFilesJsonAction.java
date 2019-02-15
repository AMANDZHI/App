package com.company.actions;

import com.company.api.Action;
import com.company.api.ServiceLocator;
import com.company.model.Domain;
import com.company.model.Project;
import com.company.model.Task;
import com.company.model.User;
import com.company.util.ActionRole;

import java.io.IOException;
import java.util.List;

public class WriteAllToFilesJsonAction implements Action {
    private ServiceLocator serviceLocator;

    @Override
    public String getName() {
        return "writeAllToFileJson";
    }

    @Override
    public String getDescription() {
        return "serialization all data to json";
    }

    @Override
    public void execute() throws IOException {
        String filePath = "exportData/all.json";
        Domain domain = serviceLocator.getDomainServiceImpl().getDomain();
        serviceLocator.getSerializationServiceImpl().writeAllToJson(filePath, domain);
        System.out.println(filePath);
    }

    @Override
    public ActionRole getRole() {
        return ActionRole.ADMIN;
    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }
}
