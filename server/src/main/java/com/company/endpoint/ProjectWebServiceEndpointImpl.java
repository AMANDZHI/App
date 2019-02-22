package com.company.endpoint;

import com.company.api.ProjectWebServiceEndpoint;
import com.company.api.Service;
import com.company.api.ServiceLocator;
import com.company.api.UserService;
import com.company.model.Project;
import com.company.model.Session;
import com.company.model.User;
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
    public void saveProject(@WebParam(name="name") String name, @WebParam(name="description") String description ,@WebParam(name="session") Session session) {
        if (serviceLocator.getSessionService().checkSession(session)) {
            Optional<User> findUser = serviceLocator.getUserService().findById(session.getUserId());
            User userSession = findUser.get();
            Project project = new Project(name, description, userSession);
            Service<String, Project> projectService = serviceLocator.getProjectService();
            projectService.save(project);
        }
    }

    @WebMethod
    @SneakyThrows
    @Override
    public Project findByNameProject(@WebParam(name="project_name") String name,@WebParam(name="session") Session session ) {
        if (serviceLocator.getSessionService().checkSession(session)) {
            Optional<Project> optionalProject = serviceLocator.getProjectService().findByName(name);
            if (optionalProject.isPresent()) {
                if (optionalProject.get().getUser().getId().equals(session.getUserId()) || serviceLocator.getUserService().findById(session.getUserId()).get().getRole().equals(UserRole.ADMIN)) {
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
            Optional<Project> optionalProject = serviceLocator.getProjectService().findById(id);
            if (optionalProject.isPresent()) {
                if (optionalProject.get().getUser().getId().equals(session.getUserId()) || serviceLocator.getUserService().findById(session.getUserId()).get().getRole().equals(UserRole.ADMIN)) {
                    return optionalProject.orElse(null);
                }
            }
        }
        return null;
    }

    @WebMethod
    @SneakyThrows
    @Override
    public void updateProject(@WebParam(name="name") String name, @WebParam(name="newName") String newName, @WebParam(name="newDescription") String newDescription, @WebParam(name="session") Session session) {
        if (serviceLocator.getSessionService().checkSession(session)) {
            Service<String, Project> projectService = serviceLocator.getProjectService();
            Optional<Project> optionalProject = projectService.findByName(name);

            if (optionalProject.isPresent()) {
                Project project = optionalProject.get();
                User user = project.getUser();

                UserService userService = serviceLocator.getUserService();
                Optional<User> optionalSessionUser = userService.findById(session.getUserId());
                User userSession = optionalSessionUser.get();

                if (user.getId().equals(session.getUserId()) || userSession.getRole().equals(UserRole.ADMIN)) {
                    project.setName(newName);
                    project.setDescription(newDescription);
                    projectService.update(project);
                }
            }
        }
    }

    @WebMethod
    @SneakyThrows
    @Override
    public void removeByNameProject(@WebParam(name="project_name") String name,@WebParam(name="session") Session session) {
        if (serviceLocator.getSessionService().checkSession(session)) {
            Optional<Project> optionalProject = serviceLocator.getProjectService().findByName(name);
            if (optionalProject.isPresent()) {
                if (optionalProject.get().getUser().getId().equals(session.getUserId()) || serviceLocator.getUserService().findById(session.getUserId()).get().getRole().equals(UserRole.ADMIN)) {
                    serviceLocator.getProjectService().removeByName(name);
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
            UserService userService = serviceLocator.getUserService();
            User userSession = userService.findById(session.getUserId()).get();

            List<Project> list = serviceLocator.getProjectService().getList();
            for (Project project: list) {
                User userProject = project.getUser();
                if (userProject.getId().equals(session.getUserId()) || userSession.getRole().equals(UserRole.ADMIN)) {
                    forClientList.add(project);
                }
            }
            return forClientList;
        }
        return null;
    }
}
