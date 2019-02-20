package com.company.repository;

import com.company.model.Project;
import com.company.model.Task;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface TaskMapperRepository {
    final static String INSERT = "INSERT INTO task_tbl (id, name, description, projectId) VALUES (#{id}, #{name}, #{description}, #{project.id})";
    final static String FIND_BY_NAME = "SELECT * FROM task_tbl WHERE name = #{name}";
    final static String FIND_BY_ID = "SELECT * FROM task_tbl WHERE id = #{id}";
    final static String UPDATE = "UPDATE task_tbl SET name = #{name}, description = #{description}, projectId = #{project.id} WHERE id = #{id}";
    final static String REMOVE_BY_NAME = "DELETE FROM task_tbl WHERE name = #{name}";
    final static String FIND_ALL = "SELECT * FROM task_tbl";

    @Select(FIND_ALL)
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "description", column = "description"),
            @Result(property = "project", column = "projectId", javaType= Project.class, one=@One(select="com.company.repository.ProjectMapperRepository.findById"))
    })
    List<Task> getList();

    @Select(FIND_BY_NAME)
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "description", column = "description"),
            @Result(property = "project", column = "projectId", javaType= Project.class, one=@One(select="com.company.repository.ProjectMapperRepository.findById"))
    })
    Task findByName(String name);

    @Select(FIND_BY_ID)
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "description", column = "description"),
            @Result(property = "project", column = "projectId", javaType= Project.class, one=@One(select="com.company.repository.ProjectMapperRepository.findById"))
    })
    Task findById(String id);

    @Insert(INSERT)
    void save(Task object);

    @Update(UPDATE)
    void update(Task task);

    @Delete(REMOVE_BY_NAME)
    void removeByName(String name);
}