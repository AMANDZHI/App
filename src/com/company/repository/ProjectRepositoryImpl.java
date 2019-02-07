package com.company.repository;

import com.company.api.Repository;
import com.company.model.Project;

import java.util.ArrayList;
import java.util.List;

public class ProjectRepositoryImpl implements Repository<Project> {
    private List<Project> list = new ArrayList<>();

    @Override
    public void save(Project object) {
        list.add(object);
    }

    @Override
    public Project findById(Integer id) {
        for (Project p: list) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public Project update(Project object) {
        list.get(object.getId()).setName(object.getName());
        list.get(object.getId()).setName(object.getDescr());
        return list.get(object.getId());
    }

    @Override
    public boolean removeById(Integer id) {
        Project project = findById(id);
        if (project != null) {
            list.remove(project);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Project> getList() {
        return list;
    }
}