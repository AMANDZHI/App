package com.company.service;

import com.company.api.Repository;
import com.company.api.Service;
import com.company.model.Project;
import com.company.model.Task;

import java.util.Map;

public class ProjectServiceImpl implements Service<String, Project> {
    private final Repository<String, Project> projectRepository;
    private final Repository<String, Task> taskRepository;

    public ProjectServiceImpl(Repository<String, Project> projectRepository, Repository<String, Task> taskRepository) {
        this.projectRepository = projectRepository;
        this.taskRepository = taskRepository;
    }

    @Override
    public void save(Project object) {
        projectRepository.save(object);
    }

    @Override
    public Project findByName(String name) {
        return projectRepository.findByName(name);
    }

    @Override
    public Project update(Project object) {
        Map<String, Task> mapTasks = taskRepository.getMap();
        for (Map.Entry<String, Task> pair: mapTasks.entrySet()) {
            if (pair.getValue().getProject().getId().equals(object.getId())) {
                Task task = pair.getValue();
                task.setProject(object);
                taskRepository.update(task);
            }
        }
        Map<String, Project> mapProjects = projectRepository.getMap();

        for (Map.Entry<String, Project> pair: mapProjects.entrySet()) {
            if (pair.getKey().equals(object.getId())) {
                return projectRepository.update(object);
            }
        }
        return null;
    }

    @Override
    public boolean removeByName(String name) {
        Project findProject = projectRepository.findByName(name);
        if (findProject != null) {
            Map<String, Task> mapTasks = taskRepository.getMap();
            for (Map.Entry<String, Task> pair: mapTasks.entrySet()) {
                if (pair.getValue().getProject().getId().equals(findProject.getId())) {
                    Task task = pair.getValue();
                    taskRepository.removeByName(task.getName());
                }
            }

            Map<String, Project> mapProjects = projectRepository.getMap();
            mapProjects.remove(findProject.getId());
            return true;
        } else{
            return false;
        }
    }

    @Override
    public Map<String, Project> getMap() {
        return projectRepository.getMap();
    }
}