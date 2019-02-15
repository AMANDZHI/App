package com.company.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

public class Session {
    private String sessionId;
    private String userId;
    private Date date;
    private String token;

    public Session() {
    }

    public Session(String userId) {
        this.userId = userId;
        this.sessionId = UUID.randomUUID().toString();
        this.date = new Date();
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
