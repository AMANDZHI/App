package com.company.api;

import com.company.model.Session;
import com.company.model.User;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface UserWebServiceEndpoint {

    void saveUser(User object, Session session);

    void updateUser(User object, Session session);

    User findByLoginUser(String login, Session session);

    User findByIdUser(String id, Session session);

    void removeByLoginUser(String login, Session session);

    List<User> getListUser(Session session);
}