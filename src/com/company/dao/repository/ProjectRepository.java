package com.company.dao.repository;

import com.company.model.Project;

import java.util.ArrayList;
import java.util.List;

public class ProjectRepository implements Repository<Project> {
    private List<Project> list = new ArrayList<>();

    @Override
    public void save(Project object) {
        list.add(object);
    }

    @Override
    public Project findById(Integer id) {
        return list.get(id);
    }

    @Override
    public Project update(Project object) {
        list.get(object.getId()).setName(object.getName());
        list.get(object.getId()).setName(object.getDescr());
        return list.get(object.getId());
    }

    @Override
    public boolean removeById(Integer id) {
        return list.remove(id);
    }

    @Override
    public List<Project> getList() {
        return list;
    }
}
