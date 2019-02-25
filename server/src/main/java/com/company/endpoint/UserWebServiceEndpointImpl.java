package com.company.endpoint;

import com.company.api.SessionService;
import com.company.api.UserService;
import com.company.api.UserWebServiceEndpoint;
import com.company.model.Session;
import com.company.model.User;
import com.company.util.Encryption;
import com.company.util.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebService;
import java.util.List;
import java.util.Optional;

@Component
@WebService(endpointInterface = "com.company.api.UserWebServiceEndpoint")
public class UserWebServiceEndpointImpl implements UserWebServiceEndpoint {

    @Autowired
    private UserService userService;

    @Autowired
    private SessionService sessionService;

    @Override
    public User saveUser(String name, String login, String password, String role, Session session) {
        if (sessionService.checkSession(session)) {
            User user = new User();
            user.setName(name);
            user.setLogin(login);
            user.setPassword(Encryption.md5Custom(password));
            user.setRole(UserRole.valueOf(role));

            User userSession = userService.findById(session.getUserId()).get();
            if (userSession.getRole().equals(UserRole.ADMIN)) {
                userService.save(user);
            }
        }
        return null;
    }

    @Override
    public User updateUser(String login, String newName, String newLogin, String newPassword, String newRole, Session session) {
        if (sessionService.checkSession(session)) {
            Optional<User> optionalUser = userService.findByLogin(login);
            if (optionalUser.isPresent()) {
                User user = optionalUser.get();
                User userSession = userService.findById(session.getUserId()).get();
                if (userSession.getRole().equals(UserRole.ADMIN)) {
                    user.setName(newName);
                    user.setLogin(newLogin);
                    user.setRole(UserRole.valueOf(newRole));
                    user.setPassword(Encryption.md5Custom(newPassword));
                    return userService.update(user);
                }
            }
        }
        return null;
    }

    @Override
    public User findByLoginUser(String login, Session session) {
        if (sessionService.checkSession(session)) {
            if (userService.findById(session.getUserId()).get().getRole().equals(UserRole.ADMIN)) {
                Optional<User> optionalLogin = userService.findByLogin(login);
                return optionalLogin.orElse(null);
            }
        }
        return null;
    }

    @Override
    public User findByIdUser(String id, Session session) {
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

    @Override
    public boolean removeByLoginUser(String login, Session session) {
        if (sessionService.checkSession(session)) {
            if (userService.findById(session.getUserId()).get().getRole().equals(UserRole.ADMIN)) {
                return userService.removeByLogin(login);
            }
        }
        return false;
    }

    @Override
    public List<User> getListUser(Session session) {
        if (sessionService.checkSession(session)) {
            if (userService.findById(session.getUserId()).get().getRole().equals(UserRole.ADMIN)) {
                return userService.getList();
            }
        }
        return null;
    }
}