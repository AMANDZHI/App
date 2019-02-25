package com.company.endpoint;

import com.company.api.ProjectWebServiceEndpoint;
import com.company.api.Service;
import com.company.api.SessionService;
import com.company.api.UserService;
import com.company.model.Project;
import com.company.model.Session;
import com.company.model.User;
import com.company.util.UserRole;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@WebService(endpointInterface = "com.company.api.ProjectWebServiceEndpoint")
public class ProjectWebServiceEndpointImpl implements ProjectWebServiceEndpoint {

    @Autowired
    @Qualifier("projectService")
    private Service<String, Project> projectService;

    @Autowired
    private SessionService sessionService;

    @Autowired
    private UserService userService;

    @SneakyThrows
    @Override
    public Project saveProject(String name, String description, Session session) {
        if (sessionService.checkSession(session)) {
            Optional<User> findUser = userService.findById(session.getUserId());
            User userSession = findUser.get();
            Project project = new Project(name, description, userSession);
            return projectService.save(project);
        }
        return null;
    }

    @SneakyThrows
    @Override
    public Project findByNameProject(String name, Session session ) {
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

    @SneakyThrows
    @Override
    public Project findByIdProject(String id, Session session) {
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

    @SneakyThrows
    @Override
    public Project updateProject(String name, String newName, String newDescription, Session session) {
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

    @SneakyThrows
    @Override
    public boolean removeByNameProject(String name, Session session) {
        if (sessionService.checkSession(session)) {
            Optional<Project> optionalProject = projectService.findByName(name);
            if (optionalProject.isPresent()) {
                if (optionalProject.get().getUser().getId().equals(session.getUserId()) || userService.findById(session.getUserId()).get().getRole().equals(UserRole.ADMIN)) {
                    return projectService.removeByName(name);
                }
            }
        }
        return false;
    }

    @SneakyThrows
    @Override
    public List getListProject(Session session) {
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
