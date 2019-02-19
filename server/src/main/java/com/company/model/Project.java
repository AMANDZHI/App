package com.company.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name="project_tbl")
public class Project implements Serializable {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "userId")
    @JoinColumn(name = "id")
    @ManyToOne
    private User user;

    public Project() {
        this.id = UUID.randomUUID().toString();
    }

    public Project(String name, String description, User user) {
        this.name = name;
        this.description = description;
        this.user = user;
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Project)) return false;

        Project project = (Project) o;

        if (getId() != null ? !getId().equals(project.getId()) : project.getId() != null) return false;
        if (getName() != null ? !getName().equals(project.getName()) : project.getName() != null) return false;
        if (getDescription() != null ? !getDescription().equals(project.getDescription()) : project.getDescription() != null) return false;
        return getUser() != null ? getUser().equals(project.getUser()) : project.getUser() == null;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", user=" + user +
                '}';
    }
}