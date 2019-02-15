package com.company.service;

import com.company.api.ServiceLocator;
import com.company.api.SessionService;
import com.company.model.Session;
import com.company.model.User;
import com.company.util.Encryption;

import java.util.Date;
import java.util.Optional;

public class SessionServiceImpl implements SessionService {
    private final ServiceLocator serviceLocator;

    public SessionServiceImpl(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    @Override
    public Session openSession(String login, String password) {
        Optional<User> optionalUser = serviceLocator.getUserServiceDB().findByLogin(login);
        if (optionalUser.isPresent()) {
            if (optionalUser.get().getPassword().equals(Encryption.md5Custom(password))) {
                Session session = new Session(optionalUser.get().getId());
                session.setToken(Encryption.encryptAes(session.getSessionId(), session.getUserId()));
                return session;
            }
        }
        return null;
    }

    @Override
    public boolean checkSession(Session session) {
        Date currentTime = new Date();
        long expireTime = (currentTime.getTime() - session.getDate().getTime())/ 1000;
        if (expireTime > 30) {
            return false;
        }

        String checkToken = Encryption.encryptAes(session.getSessionId(), session.getUserId());
        if (!checkToken.equals(session.getToken())) {
            return false;
        }
        return true;
    }

//    private final SessionRepository sessionRepository;
//
//    public SessionServiceImpl(SessionRepository sessionRepository) {
//        this.sessionRepository = sessionRepository;
//    }
//
//    @Override
//    public void save(Session session) {
//        sessionRepository.save(session);
//    }
//
//    @Override
//    public void invalidate() {
//        sessionRepository.invalidate();
//    }
//
//    @Override
//    public Session getSession() {
//        return sessionRepository.getSession();
//    }
}
