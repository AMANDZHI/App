package com.company.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@ToString
public class Task implements Serializable {
    private String id;
    private String name;
    private String description;
    private Project project;

    public Task() {
        this.id = UUID.randomUUID().toString();
    }

    public Task(String name, String description, Project project) {
        this.name = name;
        this.description = description;
        this.project = project;
        this.id = UUID.randomUUID().toString();
    }
}