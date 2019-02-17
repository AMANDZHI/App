package com.company.apiClient;


import com.company.ActionRole;

public interface Action {
    String getName();
    String getDescription();
    void execute();
    void setServiceLocatorEndpoint(ServiceLocatorEndpoint serviceLocatorEndpoint);
    ActionRole getRole();
}