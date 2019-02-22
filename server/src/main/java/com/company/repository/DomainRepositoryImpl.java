package com.company.repository;

import com.company.api.DomainRepository;
import com.company.dao.ConnectionSupplier;
import com.company.model.Domain;
import com.company.model.Project;
import com.company.model.Task;
import com.company.model.User;
import lombok.SneakyThrows;

import javax.persistence.EntityManager;
import java.util.List;

public class DomainRepositoryImpl implements DomainRepository {
    private final Domain domain = new Domain();
    private final ConnectionSupplier connectionSupplier;

    public DomainRepositoryImpl(ConnectionSupplier connectionSupplier) {
        this.connectionSupplier = connectionSupplier;
    }

    @Override
    @SneakyThrows
    public Domain getDomain() {
        EntityManager entityManager = connectionSupplier.getEntityManagerFactory().createEntityManager();

        ProjectRepositoryImpl projectRepository = new ProjectRepositoryImpl(entityManager);
        TaskRepositoryImpl taskRepository = new TaskRepositoryImpl(entityManager);
        UserRepositoryImpl userRepository = new UserRepositoryImpl(entityManager);

        List<Project> listProjects = projectRepository.getList();
        List<Task> listTasks = taskRepository.getList();
        List<User> listUsers = userRepository.getList();

        domain.setProjectList(listProjects);
        domain.setTaskList(listTasks);
        domain.setUserList(listUsers);
        return domain;
    }
}
