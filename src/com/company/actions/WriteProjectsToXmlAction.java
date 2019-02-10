package com.company.actions;

import com.company.api.Action;
import com.company.api.ServiceLocator;

import java.io.IOException;

public class WriteProjectsToXmlAction implements Action {
    private ServiceLocator serviceLocator;

    @Override
    public String getName() {
        return "writeProjectsToXml";
    }

    @Override
    public String getDescription() {
        return "serialization projects data to Xml";
    }

    @Override
    public void execute() throws IOException {
        String answerNameFilePath = CommonReader.getNameFilePathForProjects();
        serviceLocator.getProjectSerializationServiceImpl().writeObjectToXml(answerNameFilePath, serviceLocator.getProjectService().getRepository().getMap());
        System.out.println("Успешно");
    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }
}
