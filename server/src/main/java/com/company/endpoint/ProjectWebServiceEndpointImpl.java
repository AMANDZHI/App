package com.company.endpoint;

import com.company.api.ProjectWebServiceEndpoint;
import com.company.api.ServiceLocator;
import com.company.model.Project;
import com.company.model.Session;
import com.company.util.UserRole;
import lombok.SneakyThrows;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@WebService(endpointInterface = "com.company.api.ProjectWebServiceEndpoint")
public class ProjectWebServiceEndpointImpl implements ProjectWebServiceEndpoint {
    private ServiceLocator serviceLocator;

    public ProjectWebServiceEndpointImpl() {
    }

    public ProjectWebServiceEndpointImpl(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    @WebMethod
    @SneakyThrows
    @Override
    public void saveProject(@WebParam(name="project") Project object,@WebParam(name="session") Session session) {
        if (serviceLocator.getSessionService().checkSession(session)) {
            serviceLocator.getProjectServiceDB().save(object);
        }
    }

    @WebMethod
    @SneakyThrows
    @Override
    public Project findByNameProject(@WebParam(name="project_name") String name,@WebParam(name="session") Session session ) {
        if (serviceLocator.getSessionService().checkSession(session)) {
            Optional<Project> optionalProject = serviceLocator.getProjectServiceDB().findByName(name);
            if (optionalProject.isPresent()) {
                if (optionalProject.get().getUser().getId().equals(session.getUserId()) || serviceLocator.getUserServiceDB().findById(session.getUserId()).get().getRole().equals(UserRole.ADMIN)) {
                    return optionalProject.orElse(null);
                }
            }
        }
        return null;
    }

    @WebMethod
    @SneakyThrows
    @Override
    public Project findByIdProject(@WebParam(name="project_id") String id,@WebParam(name="session") Session session) {
        if (serviceLocator.getSessionService().checkSession(session)) {
            Optional<Project> optionalProject = serviceLocator.getProjectServiceDB().findById(id);
            if (optionalProject.isPresent()) {
                if (optionalProject.get().getUser().getId().equals(session.getUserId()) || serviceLocator.getUserServiceDB().findById(session.getUserId()).get().getRole().equals(UserRole.ADMIN)) {
                    return optionalProject.orElse(null);
                }
            }
        }
        return null;
    }

    @WebMethod
    @SneakyThrows
    @Override
    public void updateProject(@WebParam(name="project") Project object,@WebParam(name="session") Session session) {
        if (serviceLocator.getSessionService().checkSession(session)) {
            Optional<Project> optionalProject = serviceLocator.getProjectServiceDB().findByName(object.getName());
            if (optionalProject.isPresent()) {
                if (optionalProject.get().getUser().getId().equals(session.getUserId()) || serviceLocator.getUserServiceDB().findById(session.getUserId()).get().getRole().equals(UserRole.ADMIN)) {
                    serviceLocator.getProjectServiceDB().update(object);
                }
            }
        }
    }

    @WebMethod
    @SneakyThrows
    @Override
    public void removeByNameProject(@WebParam(name="project_name") String name,@WebParam(name="session") Session session) {
        if (serviceLocator.getSessionService().checkSession(session)) {
            Optional<Project> optionalProject = serviceLocator.getProjectServiceDB().findByName(name);
            if (optionalProject.isPresent()) {
                if (optionalProject.get().getUser().getId().equals(session.getUserId()) || serviceLocator.getUserServiceDB().findById(session.getUserId()).get().getRole().equals(UserRole.ADMIN)) {
                    serviceLocator.getProjectServiceDB().removeByName(name);
                }
            }
        }
    }

    @WebMethod
    @SneakyThrows
    @Override
    public List getListProject(@WebParam(name="session") Session session) {
        if (serviceLocator.getSessionService().checkSession(session)) {
            List<Project> forClientList = new ArrayList<>();
            List<Project> list = serviceLocator.getProjectServiceDB().getList();
            for (Project project: list) {
                if (project.getUser().getId().equals(session.getUserId()) || serviceLocator.getUserServiceDB().findById(session.getUserId()).get().getRole().equals(UserRole.ADMIN)) {
                    forClientList.add(project);
                }
            }
            return forClientList;
        }
        return null;
    }
}
