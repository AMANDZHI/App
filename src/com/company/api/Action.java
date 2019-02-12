package com.company.api;

import com.company.util.Role;

import java.io.IOException;

public interface Action {
    String getName();
    String getDescription();
    void execute() throws IOException;
    Role getRole();
    void setServiceLocator(ServiceLocator serviceLocator);
}