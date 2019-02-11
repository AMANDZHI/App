package com.company.actions;

import com.company.api.Action;
import com.company.api.ServiceLocator;
import com.company.model.Project;

import java.io.IOException;
import java.util.Map;

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
        Map<String, Project> mapProjects = serviceLocator.getProjectService().getRepository().getMap();

        if (mapProjects.size() != 0) {
            serviceLocator.getProjectSerializationServiceImpl().writeObjectToXml(answerNameFilePath, mapProjects);
        }
    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }
}
