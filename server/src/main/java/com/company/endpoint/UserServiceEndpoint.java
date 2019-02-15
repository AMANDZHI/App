package com.company.endpoint;

import com.company.api.UserServiceDB;
import com.company.model.User;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;
import java.util.Optional;

@WebService
public class UserServiceEndpoint {
    private final UserServiceDB userServiceDB;

    public UserServiceEndpoint(UserServiceDB userServiceDB) {
        this.userServiceDB = userServiceDB;
    }

    @WebMethod
    public boolean save(@WebParam(name="user") User object) {
        return userServiceDB.save(object);
    }

    @WebMethod
    public boolean update(@WebParam(name="user") User object) {
        return userServiceDB.update(object);
    }

    @WebMethod
    public Optional<User> findByLogin(@WebParam(name="user_login") String login) {
        return userServiceDB.findByLogin(login);
    }

    @WebMethod
    public Optional<User> findById(@WebParam(name="user_id") String id) {
        return userServiceDB.findById(id);
    }

    @WebMethod
    public boolean removeByLogin(@WebParam(name="user_login") String login) {
        return userServiceDB.removeByLogin(login);
    }

    @WebMethod
    public List<User> getList() {
        return userServiceDB.getList();
    }
}
