package com.company.service;

import com.company.api.Service;
import com.company.model.Project;
import com.company.repository.ProjectRepositoryData;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Component("projectService")
public class ProjectServiceImpl implements Service<String, Project> {

    @Autowired
    private ProjectRepositoryData projectRepository;

    @Override
    @SneakyThrows
    @Transactional
    public void save(Project object) {
        projectRepository.save(object);
    }

    @Override
    @SneakyThrows
    public Optional<Project> findByName(String name) {
        return projectRepository.findByName(name);
    }

    @Override
    @SneakyThrows
    public Optional<Project> findById(String id) {
        return projectRepository.findById(id);
    }

    @Override
    @SneakyThrows
    @Transactional
    public Project update(Project object) {
        Project project = projectRepository.save(object);
        return project;
    }

    @Override
    @SneakyThrows
    @Transactional
    public void removeByName(String name) {
        projectRepository.deleteByName(name);
    }

    @Override
    @SneakyThrows
    public List<Project> getList() {
        return projectRepository.findAll();
    }
}