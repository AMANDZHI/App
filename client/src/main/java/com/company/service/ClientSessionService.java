package com.company.service;

import com.company.api.Session;
import com.company.repository.ClientSessionRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ClientSessionService {
    private ClientSessionRepository clientSessionRepository;

    public void save(Session session) {
        clientSessionRepository.setSession(session);
    }

    public Session getSession() {
        return clientSessionRepository.getSession();
    }
}
