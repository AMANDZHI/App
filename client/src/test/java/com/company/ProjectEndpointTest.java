package com.company;

import com.company.api.ProjectDTO;
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
class ProjectEndpointTest {

    @Autowired
    private SessionWebServiceEndpoint sessionWebServiceEndpoint;

    @Autowired
    private ProjectWebServiceEndpoint projectWebService;

    @BeforeEach
    void initCreateData() {
        Session session = getSession();
        projectWebService.saveProject("projectTest1", "description", session);
    }

    @AfterEach
    void removeData() {
        Session session = getSession();
        projectWebService.removeByNameProject("projectTest1", session);
        projectWebService.removeByNameProject("projectTest2", session);
    }

    @Test
    void projectCreateTest() {
        Session session = getSession();
        ProjectDTO actual = projectWebService.saveProject("projectTest5", "description", session);
        Assertions.assertNotEquals(null, actual.getId());
        boolean removeActual = projectWebService.removeByNameProject("projectTest5", session);
        Assertions.assertTrue(removeActual);
    }

    @Test
    void projectFindByNameTest() {
        Session session = getSession();
        ProjectDTO actual = projectWebService.findByNameProject("projectTest1", session);
        Assertions.assertNotEquals(null, actual);
    }

    @Test
    void projectUpdateTest() {
        Session session = getSession();
        ProjectDTO actual = projectWebService.updateProject("projectTest1", "newProject", "newDescr", session);
        Assertions.assertNotEquals("project", actual.getName());
        boolean removeActual = projectWebService.removeByNameProject("newProject", session);
        Assertions.assertTrue(removeActual);
    }

    @Test
    void projectRemoveByName() {
        Session session = getSession();
        boolean actual = projectWebService.removeByNameProject("projectTest1", session);
        Assertions.assertTrue(actual);
    }

    private Session getSession() {
        return sessionWebServiceEndpoint.openSession("admin", "admin");
    }
}