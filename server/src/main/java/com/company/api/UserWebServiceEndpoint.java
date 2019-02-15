package com.company.api;

import com.company.model.Session;
import com.company.model.User;

import javax.jws.WebService;
import java.util.List;

@WebService
public interface UserWebServiceEndpoint {

    boolean save(User object, Session session);

    boolean update(User object, Session session);

    User findByLogin(String login, Session session);

    User findById(String id, Session session);

    boolean removeByLogin(String login, Session session);

    List<User> getList(Session session);
}