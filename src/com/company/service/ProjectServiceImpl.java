package com.company.service;

import com.company.api.Repository;
import com.company.api.Service;
import com.company.model.Project;
import com.company.model.Task;

import java.util.List;

public class ProjectServiceImpl implements Service<Project> {
    private Repository<Project> projectRepository;
    private Repository<Task> taskRepository;

    public ProjectServiceImpl(Repository<Project> projectRepository, Repository<Task> taskRepository) {
        this.projectRepository = projectRepository;
        this.taskRepository = taskRepository;
    }

    @Override
    public void save(Project object) {
        projectRepository.save(object);
    }

    @Override
    public Project findById(Integer id) {
        return projectRepository.findById(id);
    }

    @Override
    public Project update(Project object) {
        List<Task> listTaks = taskRepository.getList();
        for (Task task: listTaks) {
            if (task.getProject().getId().equals(object.getId())) {
                task.setProject(object);
                taskRepository.update(task);
            }
        }
        return projectRepository.update(object);
    }

    @Override
    public boolean removeById(Integer id) {
        Project project = projectRepository.findById(id);
        List<Task> listTaks = taskRepository.getList();
        for (Task task: listTaks) {
            if (task.getProject().equals(project)) {
                taskRepository.removeById(task.getId());
            }
        }
        return projectRepository.removeById(id);

    }

    @Override
    public List<Project> getList() {
        return projectRepository.getList();
    }
}