package com.company.endpoint;

import com.company.api.UserServiceDB;
import com.company.model.User;

import java.util.List;
import java.util.Optional;

public class UserServiceEndpoint {
    private final UserServiceDB userServiceDB;

    public UserServiceEndpoint(UserServiceDB userServiceDB) {
        this.userServiceDB = userServiceDB;
    }

    public boolean save(User object) {
        return userServiceDB.save(object);
    }
    
    public boolean update(User object) {
        return userServiceDB.update(object);
    }
    
    public Optional<User> findByLogin(String login) {
        return userServiceDB.findByLogin(login);
    }
    
    public Optional<User> findById(String id) {
        return userServiceDB.findById(id);
    }
    
    public boolean removeByLogin(String login) {
        return userServiceDB.removeByLogin(login);
    }
    
    public List<User> getList() {
        return userServiceDB.getList();
    }
}
