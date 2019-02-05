package com.company.ui;

import com.company.service.Service;

public interface ServiceLocator<Project, Task> {
    Service<Project> getProjectService();
    Service<Task> getTaskService();
}
