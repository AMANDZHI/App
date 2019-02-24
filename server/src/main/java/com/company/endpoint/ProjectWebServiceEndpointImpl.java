package com.company.endpoint;

import com.company.api.*;
import com.company.model.Project;
import com.company.model.Session;
import com.company.model.User;
import com.company.util.UserRole;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@WebService(endpointInterface = "com.company.api.ProjectWebServiceEndpoint")
public class ProjectWebServiceEndpointImpl implements ProjectWebServiceEndpoint {

    @Autowired
    @Qualifier("projectService")
    Service<String, Project> projectService;

    @Autowired
    SessionService sessionService;

    @Autowired
    UserService userService;

    @WebMethod
    @SneakyThrows
    @Override
    public void saveProject(@WebParam(name="name") String name, @WebParam(name="description") String description ,@WebParam(name="session") Session session) {
        if (sessionService.checkSession(session)) {
            Optional<User> findUser = userService.findById(session.getUserId());
            User userSession = findUser.get();
            Project project = new Project(name, description, userSession);
            projectService.save(project);
        }
    }

    @WebMethod
    @SneakyThrows
    @Override
    public Project findByNameProject(@WebParam(name="project_name") String name,@WebParam(name="session") Session session ) {
        if (sessionService.checkSession(session)) {
            Optional<Project> optionalProject = projectService.findByName(name);
            if (optionalProject.isPresent()) {
                if (optionalProject.get().getUser().getId().equals(session.getUserId()) || userService.findById(session.getUserId()).get().getRole().equals(UserRole.ADMIN)) {
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
        if (sessionService.checkSession(session)) {
            Optional<Project> optionalProject = projectService.findById(id);
            if (optionalProject.isPresent()) {
                if (optionalProject.get().getUser().getId().equals(session.getUserId()) || userService.findById(session.getUserId()).get().getRole().equals(UserRole.ADMIN)) {
                    return optionalProject.orElse(null);
                }
            }
        }
        return null;
    }

    @WebMethod
    @SneakyThrows
    @Override
    public Project updateProject(@WebParam(name="name") String name, @WebParam(name="newName") String newName, @WebParam(name="newDescription") String newDescription, @WebParam(name="session") Session session) {
        if (sessionService.checkSession(session)) {
            Optional<Project> optionalProject = projectService.findByName(name);

            if (optionalProject.isPresent()) {
                Project project = optionalProject.get();
                User user = project.getUser();

                Optional<User> optionalSessionUser = userService.findById(session.getUserId());
                User userSession = optionalSessionUser.get();

                if (user.getId().equals(session.getUserId()) || userSession.getRole().equals(UserRole.ADMIN)) {
                    project.setName(newName);
                    project.setDescription(newDescription);
                    return projectService.update(project);
                }
            }
        }
        return null;
    }

    @WebMethod
    @SneakyThrows
    @Override
    public void removeByNameProject(@WebParam(name="project_name") String name,@WebParam(name="session") Session session) {
        if (sessionService.checkSession(session)) {
            Optional<Project> optionalProject = projectService.findByName(name);
            if (optionalProject.isPresent()) {
                if (optionalProject.get().getUser().getId().equals(session.getUserId()) || userService.findById(session.getUserId()).get().getRole().equals(UserRole.ADMIN)) {
                    projectService.removeByName(name);
                }
            }
        }
    }

    @WebMethod
    @SneakyThrows
    @Override
    public List getListProject(@WebParam(name="session") Session session) {
        if (sessionService.checkSession(session)) {
            List<Project> forClientList = new ArrayList<>();
            User userSession = userService.findById(session.getUserId()).get();

            List<Project> list = projectService.getList();
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
