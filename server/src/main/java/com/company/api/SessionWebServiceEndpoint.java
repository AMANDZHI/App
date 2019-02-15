package com.company.api;

import com.company.model.Session;

import javax.jws.WebService;

@WebService
public interface SessionWebServiceEndpoint {
    Session openSession(String login, String password);
    boolean checkSession(Session session);
}
