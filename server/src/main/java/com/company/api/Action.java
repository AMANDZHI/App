package com.company.api;

import com.company.util.ActionRole;

import java.io.IOException;
import java.sql.SQLException;

public interface Action {
    String getName();
    String getDescription();
    void execute();
    ActionRole getRole();
    void setServiceLocator(ServiceLocator serviceLocator);
}