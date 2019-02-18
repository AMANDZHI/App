package com.company.repository;

import com.company.api.RepositoryDB;
import com.company.api.UserRepositoryDB;
import com.company.dao.ConnectionSupplier;
import com.company.mapper.ProjectMapper;
import com.company.model.Project;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Optional;

public class ProjectRepositoryDBImpl implements RepositoryDB<String, Project> {
    private final ConnectionSupplier connectionSupplier;

    public ProjectRepositoryDBImpl(ConnectionSupplier connectionSupplier) {
        this.connectionSupplier = connectionSupplier;
    }

    @Override
    public boolean save(Project object) {
        SqlSession session = connectionSupplier.getSession();
        ProjectMapper mapper = session.getMapper(ProjectMapper.class);
        mapper.save(object);
        session.commit();
        Optional<Project> checkProject = findById(object.getId());
        session.close();
        if (checkProject.isPresent()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Optional<Project> findByName(String name) {
        SqlSession session = connectionSupplier.getSession();
        ProjectMapper mapper =  session.getMapper(ProjectMapper.class);
        Project project = mapper.findByName(name);
        session.commit();
        session.close();
        return Optional.of(project);
    }

    @Override
    public Optional<Project> findById(String id) {
        SqlSession session = connectionSupplier.getSession();
        ProjectMapper mapper = session.getMapper(ProjectMapper.class);
        Project project = mapper.findById(id);
        session.commit();
        session.close();
        return Optional.of(project);
    }

    @Override
    public boolean update(Project object) {
        SqlSession session = connectionSupplier.getSession();
        ProjectMapper mapper = session.getMapper(ProjectMapper.class);
        mapper.update(object);
        session.commit();
        Optional<Project> checkProject = findById(object.getId());
        session.close();
        if (checkProject.isPresent()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean removeByName(String name) {
        SqlSession session = connectionSupplier.getSession();
        ProjectMapper mapper = session.getMapper(ProjectMapper.class);
        mapper.removeByName(name);
        session.commit();
        session.close();
        return true;
    }

    @Override
    public List<Project> getList() {
        SqlSession session = connectionSupplier.getSession();
        ProjectMapper mapper = session.getMapper(ProjectMapper.class);
        List<Project> list = mapper.getList();
        session.commit();
        session.close();
        return list;
    }
}
