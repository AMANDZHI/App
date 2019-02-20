package com.company.repository;

import com.company.model.Project;
import com.company.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ProjectMapperRepository {
    final static String INSERT = "INSERT INTO project_tbl (id, name, description, userId) VALUES (#{id}, #{name}, #{description}, #{user.id})";
    final static String FIND_BY_NAME = "SELECT * FROM project_tbl WHERE name = #{name}";
    final static String FIND_BY_ID = "SELECT * FROM project_tbl WHERE id = #{id}";
    final static String UPDATE = "UPDATE project_tbl SET name = #{name}, description = #{description}, userId = #{user.id} WHERE id = #{id}";
    final static String REMOVE_BY_NAME = "DELETE FROM project_tbl WHERE name = #{name}";
    final static String FIND_ALL = "SELECT * FROM project_tbl";

    @Select(FIND_ALL)
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "description", column = "description"),
            @Result(property = "user", column = "userId", javaType= User.class, one=@One(select="com.company.repository.UserMapperRepository.findById"))
    })
    List<Project> getList();

    @Select(FIND_BY_NAME)
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "description", column = "description"),
            @Result(property = "user", column = "userId", javaType= User.class, one=@One(select="com.company.repository.UserMapperRepository.findById"))
    })
    Project findByName(String name);

    @Select(FIND_BY_ID)
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "description", column = "description"),
            @Result(property = "user", column = "userId", javaType= User.class, one=@One(select="com.company.repository.UserMapperRepository.findById"))
    })
    Project findById(String id);

    @Insert(INSERT)
    void save(Project object);

    @Update(UPDATE)
    void update(Project project);

    @Delete(REMOVE_BY_NAME)
    void removeByName(String name);
}