package com.company.repository;

import com.company.api.SessionRepository;
import com.company.model.Session;

public class SessionRepositoryImpl implements SessionRepository {
    private Session session = new Session();

    public void save(Session session) {
        this.session = session;
    }

    public void invalidate() {
        session.setUser(null);
    }

    @Override
    public Session getSession() {
        return session;
    }
}