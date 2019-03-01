package com.company.service;

import com.company.dto.ProjectDTO;
import com.company.dto.TaskDTO;
import com.company.dto.UserDTO;
import com.company.model.Project;
import com.company.model.Task;
import com.company.model.User;

public class EntityServiceToDTO {

    public static ProjectDTO getProjectDTO(Project project) {
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setId(project.getId());
        projectDTO.setName(project.getName());
        projectDTO.setDescription(project.getDescription());
        projectDTO.setUserId(project.getUser().getId());
        return projectDTO;
    }

    public static TaskDTO getTaskDTO(Task task) {
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setId(task.getId());
        taskDTO.setName(task.getName());
        taskDTO.setDescription(task.getDescription());
        taskDTO.setProjectId(task.getProject().getId());
        taskDTO.setUserId(task.getUser().getId());
        return taskDTO;
    }

    public static UserDTO getUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setLogin(user.getLogin());
        userDTO.setPassword(user.getPassword());
        userDTO.setRole(user.getRole().toString());
        return userDTO;
    }
}