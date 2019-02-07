package com.company.service;

import com.company.api.SessionRepository;
import com.company.api.SessionService;
import com.company.model.Session;

public class SessionServiceImpl implements SessionService {
    private final SessionRepository sessionRepository;

    public SessionServiceImpl(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    @Override
    public void save(Session session) {
        sessionRepository.save(session);
    }

    @Override
    public void invalidate() {
        sessionRepository.invalidate();
    }

    @Override
    public Session getSession() {
        return sessionRepository.getSession();
    }
}
