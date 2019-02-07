package com.company.api;

import com.company.model.Project;
import com.company.model.Task;

public interface ServiceLocator {
    Service<Project> getProjectService();
    Service<Task> getTaskService();
    UserService getUserService();
    SessionService getSessionService();
}
