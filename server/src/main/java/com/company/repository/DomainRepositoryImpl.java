package com.company.repository;

import com.company.api.DomainRepository;
import com.company.api.Repository;
import com.company.api.UserRepository;
import com.company.model.Domain;
import com.company.model.Project;
import com.company.model.Task;
import lombok.SneakyThrows;

public class DomainRepositoryImpl implements DomainRepository {
    private final Domain domain = new Domain();
    private final Repository<String, Project> projectRepository;
    private final UserRepository userRepository;
    private final Repository<String, Task> taskRepository;

    public DomainRepositoryImpl(Repository<String, Project> projectRepository, UserRepository userRepository, Repository<String, Task> taskRepository) {
        this.projectRepository = projectRepository;
        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
    }

    @Override
    @SneakyThrows
    public Domain getDomain() {
        domain.setProjectList(projectRepository.getList());
        domain.setTaskList(taskRepository.getList());
        domain.setUserList(userRepository.getList());
        return domain;
    }
}
