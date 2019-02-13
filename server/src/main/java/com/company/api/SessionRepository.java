package com.company.api;

import com.company.model.Session;

public interface SessionRepository {
    void save(Session session);
    void invalidate();
    Session getSession();
}
