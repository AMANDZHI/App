package com.company.repository;

import com.company.api.Repository;
import com.company.model.Task;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class TaskRepositoryImpl implements Repository<String, Task> {
    private Map<String, Task> map = new HashMap<>();

    @Override
    public void save(Task object) {
        map.put(object.getId(), object);
    }

    @Override
    public Task findByName(String name) {
        for (Map.Entry<String, Task> pair: map.entrySet()) {
            if (pair.getValue().getName().equals(name)) {
                return pair.getValue();
            }
        }
        return null;
    }

    @Override
    public Task update(Task object) {
        return map.put(object.getId(), object);
    }

    @Override
    public boolean removeByName(String name) {
        Task task = findByName(name);
        map.remove(task.getId());
        return true;
    }

    @Override
    public Map<String, Task> getMap() {
        return map;
    }

    @Override
    public void setMap(Map<String, Task> map) {
        this.map = map;
    }
}