package com.company.endpoint;

import com.company.api.SessionService;
import com.company.api.SessionWebServiceEndpoint;
import com.company.model.Session;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(endpointInterface = "com.company.api.SessionWebServiceEndpoint")
public class SessionWebServiceEndpointImpl implements SessionWebServiceEndpoint {
    private SessionService sessionService;

    public SessionWebServiceEndpointImpl() {
    }

    public SessionWebServiceEndpointImpl(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @Override
    @WebMethod
    public Session openSession(@WebParam(name="login") String login,@WebParam(name="password") String password) {
        return sessionService.openSession(login, password);
    }

    @Override
    @WebMethod
    public boolean checkSession(@WebParam(name="session") Session session) {
        return sessionService.checkSession(session);
    }
}
