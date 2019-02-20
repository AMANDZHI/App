package com.company.endpoint;

import com.company.api.SessionService;
import com.company.api.UserService;
import com.company.api.UserWebServiceEndpoint;
import com.company.model.Session;
import com.company.model.User;
import com.company.util.Encryption;
import com.company.util.UserRole;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;
import java.util.Optional;

@WebService(endpointInterface = "com.company.api.UserWebServiceEndpoint")
public class UserWebServiceEndpointImpl implements UserWebServiceEndpoint {
    private UserService userService;
    private SessionService sessionService;

    public UserWebServiceEndpointImpl() {
    }

    public UserWebServiceEndpointImpl(UserService userService, SessionService sessionService) {
        this.userService = userService;
        this.sessionService = sessionService;
    }

    @WebMethod
    @Override
    public void saveUser(@WebParam(name="user") User object, @WebParam(name="session")Session session) {
        if (sessionService.checkSession(session)) {
            object.setPassword(Encryption.md5Custom(object.getPassword()));
            if (userService.findById(session.getUserId()).get().getRole().equals(UserRole.ADMIN)) {
                userService.save(object);
            }
        }
    }

    @WebMethod
    @Override
    public void updateUser(@WebParam(name="user") User object, @WebParam(name="session")Session session) {
        if (sessionService.checkSession(session)) {
            object.setPassword(Encryption.md5Custom(object.getPassword()));
            if (userService.findById(session.getUserId()).get().getRole().equals(UserRole.ADMIN)) {
                userService.update(object);
            }
        }
    }

    @WebMethod
    @Override
    public User findByLoginUser(@WebParam(name="user_login") String login, @WebParam(name="session")Session session) {
        if (sessionService.checkSession(session)) {
            if (userService.findById(session.getUserId()).get().getRole().equals(UserRole.ADMIN)) {
                Optional<User> optionalLogin = userService.findByLogin(login);
                return optionalLogin.orElse(null);
            }
        }
        return null;
    }

    @WebMethod
    @Override
    public User findByIdUser(@WebParam(name="user_id") String id,@WebParam(name="session")Session session) {
        if (sessionService.checkSession(session)) {
            Optional<User> optionalUser = userService.findById(id);
            System.out.println(optionalUser.get());
            if (!optionalUser.isPresent()) {return null;}
            if (optionalUser.get().getRole().equals(UserRole.ADMIN)) {
                return optionalUser.get();
            }
            if (session.getUserId().equals(optionalUser.get().getId())) {
                return optionalUser.get();
            }
        }
        return null;
    }

    @WebMethod
    @Override
    public void removeByLoginUser(@WebParam(name="user_login") String login, @WebParam(name="session")Session session) {
        if (sessionService.checkSession(session)) {
            if (userService.findById(session.getUserId()).get().getRole().equals(UserRole.ADMIN)) {
                userService.removeByLogin(login);
            }
        }
    }

    @WebMethod
    @Override
    public List<User> getListUser(@WebParam(name="session")Session session) {
        if (sessionService.checkSession(session)) {
            if (userService.findById(session.getUserId()).get().getRole().equals(UserRole.ADMIN)) {
                return userService.getList();
            }
        }
        return null;
    }
}