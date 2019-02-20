package com.company.service;

import com.company.api.ServiceDB;
import com.company.dao.ConnectionSupplier;
import com.company.repository.ProjectMapperRepository;
import com.company.model.Project;
import lombok.SneakyThrows;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Optional;

public class ProjectServiceDBImpl implements ServiceDB<String, Project> {
    private final ConnectionSupplier connectionSupplier;

    public ProjectServiceDBImpl(ConnectionSupplier connectionSupplier) {
        this.connectionSupplier = connectionSupplier;
    }

    @Override
    @SneakyThrows
    public void save(Project object) {
        SqlSession session = connectionSupplier.getSession();
        ProjectMapperRepository mapper = session.getMapper(ProjectMapperRepository.class);
        mapper.save(object);
        session.commit();
        session.close();
    }

    @Override
    @SneakyThrows
    public Optional<Project> findByName(String name) {
        SqlSession session = connectionSupplier.getSession();
        ProjectMapperRepository mapper =  session.getMapper(ProjectMapperRepository.class);
        Project project = mapper.findByName(name);
        session.commit();
        session.close();
        return Optional.of(project);
    }

    @Override
    @SneakyThrows
    public Optional<Project> findById(String id) {
        SqlSession session = connectionSupplier.getSession();
        ProjectMapperRepository mapper = session.getMapper(ProjectMapperRepository.class);
        Project project = mapper.findById(id);
        session.commit();
        session.close();
        return Optional.of(project);
    }

    @Override
    @SneakyThrows
    public void update(Project object) {
        SqlSession session = connectionSupplier.getSession();
        ProjectMapperRepository mapper = session.getMapper(ProjectMapperRepository.class);
        mapper.update(object);
        session.commit();
        session.close();
    }

    @Override
    @SneakyThrows
    public void removeByName(String name) {
        SqlSession session = connectionSupplier.getSession();
        ProjectMapperRepository mapper = session.getMapper(ProjectMapperRepository.class);
        mapper.removeByName(name);
        session.commit();
        session.close();
    }

    @Override
    @SneakyThrows
    public List<Project> getList() {
        SqlSession session = connectionSupplier.getSession();
        ProjectMapperRepository mapper = session.getMapper(ProjectMapperRepository.class);
        List<Project> list = mapper.getList();
        session.commit();
        session.close();
        return list;
    }
}