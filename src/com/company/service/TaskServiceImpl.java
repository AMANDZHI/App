package com.company.service;

import com.company.api.Repository;
import com.company.api.Service;
import com.company.model.Task;

import java.util.Map;

public class TaskServiceImpl implements Service<String, Task> {
    private final Repository<String, Task> taskRepository;

    public TaskServiceImpl(Repository<String, Task> taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void save(Task object) {
        taskRepository.save(object);
    }

    @Override
    public Task findByName(String name) {
        return taskRepository.findByName(name);
    }

    @Override
    public Task update(Task object) {
        return taskRepository.update(object);
    }

    @Override
    public boolean removeByName(String name) {
        if (findByName(name) != null) {
            taskRepository.removeByName(name);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Map<String, Task> getMap() {
        return taskRepository.getMap();
    }
}
