package com.company.ui;

import com.company.model.Project;
import com.company.model.Task;
import com.company.model.User;
import com.company.service.Service;

public interface ServiceLocator {
    Service<Project> getProjectService();
    Service<Task> getTaskService();
    Service<User> getUserService();
}
