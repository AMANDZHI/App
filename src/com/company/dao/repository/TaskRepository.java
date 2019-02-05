package com.company.dao.repository;

import com.company.model.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskRepository implements Repository<Task> {
    private List<Task> list = new ArrayList<>();

    @Override
    public void save(Task object) {
        list.add(object);
    }

    @Override
    public Task findById(Integer id) {
        return list.get(id);
    }

    @Override
    public Task update(Task object) {
        list.get(object.getId()).setName(object.getName());
        list.get(object.getId()).setName(object.getDescr());
        list.get(object.getId()).setProject(object.getProject());
        return list.get(object.getId());
    }

    @Override
    public boolean removeById(Integer id) {
        return list.remove(id);
    }

    @Override
    public List<Task> getList() {
        return list;
    }
}