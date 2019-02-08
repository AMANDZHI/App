package com.company.api;

import java.io.IOException;

public interface Action {
    String getName();
    String getDescription();
    void execute() throws IOException;
    void setServiceLocator(ServiceLocator serviceLocator);
}