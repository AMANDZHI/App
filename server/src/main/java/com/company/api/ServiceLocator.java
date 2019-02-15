package com.company.api;

import com.company.model.Project;
import com.company.model.Task;

public interface ServiceLocator {
    SessionService getSessionService();
    SerializationService getSerializationServiceImpl();
    ServiceDB<String, Project> getProjectServiceDB();
    ServiceDB<String, Task> getTaskServiceDB();
    UserServiceDB getUserServiceDB();
    DomainService getDomainServiceImpl();
}