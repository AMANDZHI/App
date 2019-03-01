package com.company.service;

import com.company.api.Session;
import com.company.repository.ClientSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientSessionService {
    @Autowired
    private ClientSessionRepository clientSessionRepository;

    public void save(Session session) {
        clientSessionRepository.setSession(session);
    }

    public Session getSession() {
        return clientSessionRepository.getSession();
    }
}
