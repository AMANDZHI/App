//package com.company;
//
//import com.company.api.Project;
//import com.company.api.ProjectWebServiceEndpoint;
//import com.company.api.Session;
//import com.company.apiClient.ServiceLocatorEndpoint;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//
//public class ProjectEndpointTest {
//    private ServiceLocatorEndpoint serviceLocatorEndpoint;
//
//    public ProjectEndpointTest(ServiceLocatorEndpoint serviceLocatorEndpoint) {
//        this.serviceLocatorEndpoint = serviceLocatorEndpoint;
//    }
//
//    @Test
//    public void projectCreateTest() {
//        Session session = serviceLocatorEndpoint.getSessionWebService().openSession("admin", "admin");
//        ProjectWebServiceEndpoint projectWebService = serviceLocatorEndpoint.getProjectWebService();
//        Project actualFirst = projectWebService.saveProject("project1", "description", session);
//        Project actualSecond = projectWebService.saveProject("project2", "description", session);
//        Assertions.assertNotEquals(null, actualFirst.getId());
//        Assertions.assertNotEquals(null, actualSecond.getId());
//    }
//
//    @Test
//    public void projectFindByNameTest() {
//        Session session = serviceLocatorEndpoint.getSessionWebService().openSession("admin", "admin");
//        ProjectWebServiceEndpoint projectWebService = serviceLocatorEndpoint.getProjectWebService();
//        Project project = projectWebService.findByNameProject("project1", session);
//        Assertions.assertNotEquals(null, project);
//    }
//
//    @Test
//    public void projectUpdateTest() {
//        Session session = serviceLocatorEndpoint.getSessionWebService().openSession("admin", "admin");
//        ProjectWebServiceEndpoint projectWebService = serviceLocatorEndpoint.getProjectWebService();
//        Project actual = projectWebService.updateProject("project2", "newProject", "newDescr", session);
//        Assertions.assertNotEquals("project2", actual.getName());
//    }
//}
