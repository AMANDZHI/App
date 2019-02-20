package com.company.repository;

import com.company.api.DomainRepository;
import com.company.dao.ConnectionSupplier;
import com.company.model.Domain;
import com.company.model.Project;
import com.company.model.Task;
import lombok.SneakyThrows;
import org.apache.ibatis.session.SqlSession;

public class DomainRepositoryImpl implements DomainRepository {
    private final Domain domain = new Domain();
    private final ConnectionSupplier connectionSupplier;

    public DomainRepositoryImpl(ConnectionSupplier connectionSupplier) {
        this.connectionSupplier = connectionSupplier;
    }

    @Override
    @SneakyThrows
    public Domain getDomain() {
        SqlSession session = connectionSupplier.getSession();
        ProjectMapperRepository projectRepository = session.getMapper(ProjectMapperRepository.class);
        TaskMapperRepository taskRepository = session.getMapper(TaskMapperRepository.class);
        UserMapperRepository userRepository = session.getMapper(UserMapperRepository.class);

        domain.setProjectList(projectRepository.getList());
        domain.setTaskList(taskRepository.getList());
        domain.setUserList(userRepository.getList());
        return domain;
    }
}
