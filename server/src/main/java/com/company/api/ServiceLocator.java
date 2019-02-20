package com.company.api;

import com.company.model.Project;
import com.company.model.Task;

public interface ServiceLocator {
    SessionService getSessionService();
    SerializationService getSerializationServiceImpl();
    Service<String, Project> getProjectService();
    Service<String, Task> getTaskService();
    UserService getUserService();
    DomainService getDomainServiceImpl();
}