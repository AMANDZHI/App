package com.company;

import com.company.api.*;
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
public class TaskEndpointTest {

    @Autowired
    private SessionWebServiceEndpoint sessionWebServiceEndpoint;

    @Autowired
    private TaskWebServiceEndpoint taskWebService;

    @Autowired
    private ProjectWebServiceEndpoint projectWebService;


    @BeforeEach
    public void initCreateData() {
        Session session = getSession();
        projectWebService.saveProject("projectTest1", "description1", session);
        projectWebService.saveProject("projectTest2", "description2", session);
        taskWebService.saveTask("taskTest", "description", "projectTest1", session);
    }

    @AfterEach
    public void removeData() {
        Session session = getSession();
        projectWebService.removeByNameProject("projectTest1", session);
        projectWebService.removeByNameProject("projectTest2", session);
        taskWebService.removeByNameTask("taskTest", session);
    }

    @Test
    public void taskCreateTest() {
        Session session = getSession();
        Task actual = taskWebService.saveTask("taskTest5", "description", "projectTest1",  session);
        Assertions.assertNotEquals(null, actual.getId());
        taskWebService.removeByNameTask("taskTest5", session);
    }

    @Test
    public void taskFindByNameTest() {
        Session session = getSession();
        Task task = taskWebService.findByNameTask("taskTest", session);
        Assertions.assertNotEquals(null, task);
    }

    @Test
    public void taskUpdateTest() {
        Session session = getSession();
        Task actual = taskWebService.updateTask("taskTest", "newTask", "newDescr", "projectTest2", session);
        Assertions.assertNotEquals("taskTest", actual.getName());
        taskWebService.removeByNameTask("newTask", session);
    }

    @Test
    public void taskRemoveByName() {
        Session session = getSession();
        boolean actual = taskWebService.removeByNameTask("taskTest", session);
        Assertions.assertTrue(actual);
    }

    private Session getSession() {
        return sessionWebServiceEndpoint.openSession("admin", "admin");
    }
}
