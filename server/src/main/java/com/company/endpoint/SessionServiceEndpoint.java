package com.company.endpoint;

import com.company.api.SessionService;
import com.company.model.Session;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public class SessionServiceEndpoint {
    private final SessionService sessionService;

    public SessionServiceEndpoint(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @WebMethod
    public void save(@WebParam(name="session") Session session) {
        sessionService.save(session);
    }

    @WebMethod
    public void invalidate() {
        sessionService.invalidate();
    }

    @WebMethod
    public Session getSession() {
        return sessionService.getSession();
    }
}
