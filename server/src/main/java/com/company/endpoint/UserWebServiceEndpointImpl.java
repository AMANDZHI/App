package com.company.endpoint;

import com.company.api.SessionService;
import com.company.api.UserServiceDB;
import com.company.api.UserWebServiceEndpoint;
import com.company.model.Session;
import com.company.model.User;
import com.company.util.UserRole;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;
import java.util.Optional;

@WebService(endpointInterface = "com.company.api.UserWebServiceEndpoint")
public class UserWebServiceEndpointImpl implements UserWebServiceEndpoint {
    private UserServiceDB userServiceDB;
    private SessionService sessionService;

    public UserWebServiceEndpointImpl(UserServiceDB userServiceDB, SessionService sessionService) {
        this.userServiceDB = userServiceDB;
        this.sessionService = sessionService;
    }

    @WebMethod
    @Override
    public boolean save(@WebParam(name="user") User object, @WebParam(name="session")Session session) {
        if (sessionService.checkSession(session)) {
            if (userServiceDB.findById(session.getUserId()).get().getRole().equals(UserRole.ADMIN)) {
                return userServiceDB.save(object);
            }
        }
        return false;
    }

    @WebMethod
    @Override
    public boolean update(@WebParam(name="user") User object, @WebParam(name="session")Session session) {
        if (sessionService.checkSession(session)) {
            if (userServiceDB.findById(session.getUserId()).get().getRole().equals(UserRole.ADMIN)) {
                return userServiceDB.update(object);
            }
        }
        return false;
    }

    @WebMethod
    @Override
    public User findByLogin(@WebParam(name="user_login") String login, @WebParam(name="session")Session session) {
        if (sessionService.checkSession(session)) {
            if (userServiceDB.findById(session.getUserId()).get().getRole().equals(UserRole.ADMIN)) {
                Optional<User> optionalLogin = userServiceDB.findByLogin(login);
                return optionalLogin.orElse(null);
            }
        }
        return null;
    }

    @WebMethod
    @Override
    public User findById(@WebParam(name="user_id") String id,@WebParam(name="session")Session session) {
        if (sessionService.checkSession(session)) {
            if (userServiceDB.findById(session.getUserId()).get().getRole().equals(UserRole.ADMIN)) {
                Optional<User> optionalUser = userServiceDB.findById(id);
                return optionalUser.orElse(null);
            }
        }
        return null;
    }

    @WebMethod
    @Override
    public boolean removeByLogin(@WebParam(name="user_login") String login, @WebParam(name="session")Session session) {
        if (sessionService.checkSession(session)) {
            if (userServiceDB.findById(session.getUserId()).get().getRole().equals(UserRole.ADMIN)) {
                return userServiceDB.removeByLogin(login);
            }
        }
        return false;
    }

    @WebMethod
    @Override
    public List<User> getList(@WebParam(name="session")Session session) {
        if (sessionService.checkSession(session)) {
            if (userServiceDB.findById(session.getUserId()).get().getRole().equals(UserRole.ADMIN)) {
                return userServiceDB.getList();
            }
        }
        return null;
    }
}