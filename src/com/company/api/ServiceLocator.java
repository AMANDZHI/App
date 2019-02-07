package com.company.api;

import com.company.model.Project;
import com.company.model.Task;

public interface ServiceLocator {
    Service<String, Project> getProjectService();
    Service<String, Task> getTaskService();
    UserService getUserService();
    SessionService getSessionService();
}
