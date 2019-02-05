package com.company.model;

public class Task {
    private Integer id;
    private String name;
    private String descr;
    private Project project;

    public Task() {
    }

    public Task(Integer id, String name, String descr, Project project) {
        this.id = id;
        this.name = name;
        this.descr = descr;
        this.project = project;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", descr='" + descr + '\'' +
                ", project=" + project +
                '}';
    }
}