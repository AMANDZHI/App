package com.company.service;

import com.company.dao.repository.Repository;
import com.company.dao.repository.TaskRepository;
import com.company.model.Task;

import java.util.List;

public class TaskServiceImpl implements Service<Task> {
    private Repository<Task> taskRepository;

    public TaskServiceImpl(Repository<Task> taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void save(Task object) {
        taskRepository.save(object);
    }

    @Override
    public Task findById(Integer id) {
        return taskRepository.findById(id);
    }

    @Override
    public Task update(Task object) {
        return taskRepository.update(object);
    }

    @Override
    public boolean removeById(Integer id) {
        return taskRepository.removeById(id);
    }

    @Override
    public List<Task> getList() {
        return taskRepository.getList();
    }
}
