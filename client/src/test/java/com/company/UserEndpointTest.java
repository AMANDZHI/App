package com.company;

import com.company.api.Session;
import com.company.api.SessionWebServiceEndpoint;
import com.company.api.User;
import com.company.api.UserWebServiceEndpoint;
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
class UserEndpointTest {

    @Autowired
    private SessionWebServiceEndpoint sessionWebServiceEndpoint;

    @Autowired
    private UserWebServiceEndpoint userWebService;

    @BeforeEach
    void initCreateData() {
        Session session = getSession();
        userWebService.saveUser("userTest", "userTest","userTest", "user", session);
    }

    @AfterEach
    void removeData() {
        Session session = getSession();
        userWebService.removeByLoginUser("userTest", session);
    }

    @Test
    void userCreateTest() {
        Session session = getSession();
        User actual = userWebService.saveUser("userTest5", "userTest5", "userTest5", "user", session);
        Assertions.assertNotEquals(null, actual.getId());
        boolean removeActual = userWebService.removeByLoginUser("userTest5", session);
        Assertions.assertTrue(removeActual);
    }

    @Test
    void userFindByLoginTest() {
        Session session = getSession();
        User actual = userWebService.findByLoginUser("userTest", session);
        Assertions.assertNotEquals(null, actual);
    }

    @Test
    void userUpdateTest() {
        Session session = getSession();
        User actual = userWebService.updateUser("userTest", "newUser", "newUser","newPassword", "user", session);
        Assertions.assertNotEquals("user", actual.getLogin());
        boolean removeActual = userWebService.removeByLoginUser("newUser", session);
        Assertions.assertTrue(removeActual);
    }

    @Test
    void userRemoveByName() {
        Session session = getSession();
        boolean actual = userWebService.removeByLoginUser("userTest", session);
        Assertions.assertTrue(actual);
    }

    private Session getSession() {
        return sessionWebServiceEndpoint.openSession("admin", "admin");
    }
}
