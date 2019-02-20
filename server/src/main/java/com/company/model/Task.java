package com.company.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name="task_tbl")
@Getter
@Setter
@ToString
public class Task implements Serializable {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "projectId", referencedColumnName = "id")
    @ManyToOne
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