package com.company.endpoint;

import com.company.api.SerializationWebServiceEndpoint;
import com.company.api.ServiceLocator;
import com.company.model.Domain;
import com.company.model.Project;
import com.company.model.Task;
import com.company.model.User;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService(endpointInterface = "com.company.api.SerializationWebServiceEndpoint")
public class SerializationWebServiceEndpointImpl implements SerializationWebServiceEndpoint {
    private ServiceLocator serviceLocator;

    public SerializationWebServiceEndpointImpl() {
    }

    public SerializationWebServiceEndpointImpl(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    @WebMethod
    @Override
    public void writeObjectsToFiles() {
        List<Project> listProjects = serviceLocator.getDomainServiceImpl().getDomain().getProjectList();
        List<Task> listUsers = serviceLocator.getDomainServiceImpl().getDomain().getTaskList();
        List<User> listTasks = serviceLocator.getDomainServiceImpl().getDomain().getUserList();

        String filePathUsers = "exportData/users.txt";
        String filePathTasks = "exportData/tasks.txt";
        String filePathProjects = "exportData/projects.txt";

        if (listProjects.size() != 0) {
            serviceLocator.getSerializationServiceImpl().writeObjectToFile(filePathProjects, listProjects);
        }
        if (listUsers.size() != 0) {
            serviceLocator.getSerializationServiceImpl().writeObjectToFile(filePathUsers, listUsers);
        }
        if (listTasks.size() != 0) {
            serviceLocator.getSerializationServiceImpl().writeObjectToFile(filePathTasks, listTasks);
        }
    }

    @WebMethod
    @Override
    public void readFilesToObjects() {
        String filePathUsers = "exportData/users.txt";
        String filePathTasks = "exportData/tasks.txt";
        String filePathProjects = "exportData/projects.txt";

        List<Project> listProjects = serviceLocator.getSerializationServiceImpl().readFileToObject(filePathProjects);
        List<User> listUsers = serviceLocator.getSerializationServiceImpl().readFileToObject(filePathUsers);
        List<Task> listTasks = serviceLocator.getSerializationServiceImpl().readFileToObject(filePathTasks);

        for (User u: listUsers) {
            if (!serviceLocator.getUserServiceDB().findByLogin(u.getLogin()).isPresent()) {
                serviceLocator.getUserServiceDB().save(u);
            }
        }

        for (Project p: listProjects) {
            if (!serviceLocator.getProjectServiceDB().findById(p.getId()).isPresent()) {
                serviceLocator.getProjectServiceDB().save(p);
            }
        }

        for (Task t: listTasks) {
            if (!serviceLocator.getTaskServiceDB().findById(t.getId()).isPresent()) {
                serviceLocator.getTaskServiceDB().save(t);
            }
        }
    }

    @WebMethod
    @Override
    public void writeAllToJson() {
        String filePath = "exportData/all.json";
        Domain domain = serviceLocator.getDomainServiceImpl().getDomain();
        serviceLocator.getSerializationServiceImpl().writeAllToJson(filePath, domain);
    }

    @WebMethod
    @Override
    public void writeAllToXml() {
        String filePath = "exportData/all.xml";
        Domain domain = serviceLocator.getDomainServiceImpl().getDomain();
        serviceLocator.getSerializationServiceImpl().writeAllToXml(filePath, domain);
    }

    @WebMethod
    @Override
    public void readJsonToObjects() {
        String filePath = "exportData/all.json";
        serviceLocator.getSerializationServiceImpl().readJsonToObjects(filePath);
    }

    @WebMethod
    @Override
    public void readXmlToObjects() {
        String filePath = "exportData/all.xml";
        serviceLocator.getSerializationServiceImpl().readXmlToObjects(filePath);
    }
}
