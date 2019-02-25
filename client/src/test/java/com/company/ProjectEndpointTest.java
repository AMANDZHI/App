package com.company;

import com.company.api.Project;
import com.company.api.ProjectWebServiceEndpoint;
import com.company.api.Session;
import com.company.api.SessionWebServiceEndpoint;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ConfigurationTest.class})
public class ProjectEndpointTest {

    @Autowired
    private SessionWebServiceEndpoint sessionWebServiceEndpoint;

    @Autowired
    private ProjectWebServiceEndpoint projectWebService;

    @BeforeEach
    public void initCreateData() {
        Session session = getSession();
        projectWebService.saveProject("projectTest1", "description", session);
    }

    @AfterEach
    public void removeData() {
        Session session = getSession();
        projectWebService.removeByNameProject("projectTest1", session);
        projectWebService.removeByNameProject("projectTest2", session);
    }

    @Test
    public void projectCreateTest() {
        Session session = getSession();
        Project actual = projectWebService.saveProject("projectTest5", "description", session);
        Assertions.assertNotEquals(null, actual.getId());
        projectWebService.removeByNameProject("projectTest5", session);
    }

    @Test
    public void projectFindByNameTest() {
        Session session = getSession();
        Project actual = projectWebService.findByNameProject("projectTest1", session);
        Assertions.assertNotEquals(null, actual);
    }

    @Test
    public void projectUpdateTest() {
        Session session = getSession();
        Project actual = projectWebService.updateProject("projectTest1", "newProject", "newDescr", session);
        Assertions.assertNotEquals("project", actual.getName());
        projectWebService.removeByNameProject("newProject", session);
    }

    @Test
    public void projectRemoveByName() {
        Session session = getSession();
        boolean actual = projectWebService.removeByNameProject("projectTest1", session);
        Assertions.assertTrue(actual);
    }

    private Session getSession() {
        return sessionWebServiceEndpoint.openSession("admin", "admin");
    }
}