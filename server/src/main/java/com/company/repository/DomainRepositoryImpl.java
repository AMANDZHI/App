package com.company.repository;

import com.company.api.DomainRepository;
import com.company.api.RepositoryDB;
import com.company.api.UserRepositoryDB;
import com.company.model.Domain;
import com.company.model.Project;
import com.company.model.Task;
import lombok.SneakyThrows;

public class DomainRepositoryImpl implements DomainRepository {
    private final Domain domain = new Domain();
    private final RepositoryDB<String, Project> projectRepository;
    private final UserRepositoryDB userRepository;
    private final RepositoryDB<String, Task> taskRepository;

    public DomainRepositoryImpl(RepositoryDB<String, Project> projectRepository, UserRepositoryDB userRepository, RepositoryDB<String, Task> taskRepository) {
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
