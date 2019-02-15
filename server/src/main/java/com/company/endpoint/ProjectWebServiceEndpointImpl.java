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

    public ProjectWebServiceEndpointImpl(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    @WebMethod
    @SneakyThrows
    @Override
    public boolean save(@WebParam(name="project") Project object,@WebParam(name="session") Session session) {
        if (serviceLocator.getSessionService().checkSession(session)) {
            return serviceLocator.getProjectServiceDB().save(object);
        }
        return false;
    }

    @WebMethod
    @SneakyThrows
    @Override
    public Project findByName(@WebParam(name="project_name") String name,@WebParam(name="session") Session session ) {
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
    public Project findById(@WebParam(name="project_id") String id,@WebParam(name="session") Session session) {
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
    public boolean update(@WebParam(name="project") Project object,@WebParam(name="session") Session session) {
        if (serviceLocator.getSessionService().checkSession(session)) {
            Optional<Project> optionalProject = serviceLocator.getProjectServiceDB().findByName(object.getName());
            if (optionalProject.isPresent()) {
                if (optionalProject.get().getUser().getId().equals(session.getUserId()) || serviceLocator.getUserServiceDB().findById(session.getUserId()).get().getRole().equals(UserRole.ADMIN)) {
                    return serviceLocator.getProjectServiceDB().update(object);
                }
            }
        }
        return false;
    }

    @WebMethod
    @SneakyThrows
    @Override
    public boolean removeByName(@WebParam(name="project_name") String name,@WebParam(name="session") Session session) {
        if (serviceLocator.getSessionService().checkSession(session)) {
            Optional<Project> optionalProject = serviceLocator.getProjectServiceDB().findByName(name);
            if (optionalProject.isPresent()) {
                if (optionalProject.get().getUser().getId().equals(session.getUserId()) || serviceLocator.getUserServiceDB().findById(session.getUserId()).get().getRole().equals(UserRole.ADMIN)) {
                    return serviceLocator.getProjectServiceDB().removeByName(name);
                }
            }
        }
        return false;
    }

    @WebMethod
    @SneakyThrows
    @Override
    public List getList(@WebParam(name="session") Session session) {
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
