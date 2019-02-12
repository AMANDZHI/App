package com.company.api;

import com.company.model.Project;
import com.company.model.Task;
import com.company.service.AppSecurity;

public interface ServiceLocator {
    SessionService getSessionService();
    AppSecurity getAppSecurity();
    SerializationService getProjectSerializationServiceImpl();
    SerializationService getTaskSerializationServiceImpl();
    SerializationService getUserSerializationServiceImpl();
    ServiceDB<String, Project> getProjectServiceDB();
    ServiceDB<String, Task> getTaskServiceDB();
    UserServiceDB getUserServiceDB();
}