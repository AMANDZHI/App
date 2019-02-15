package com.company.endpoint;

import com.company.api.SessionService;
import com.company.model.Session;

public class SessionServiceEndpoint {
    private final SessionService sessionService;

    public SessionServiceEndpoint(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    public void save(Session session) {
        sessionService.save(session);
    }

    public void invalidate() {
        sessionService.invalidate();
    }

    public Session getSession() {
        return sessionService.getSession();
    }
}
