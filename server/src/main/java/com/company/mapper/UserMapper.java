package com.company.mapper;

import com.company.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    final static String INSERT = "INSERT INTO user_tbl (id, name, login, password, role) VALUES (#{id}, #{name}, #{login}, #{password}, #{role})";
    final static String FIND_BY_LOGIN = "SELECT * FROM user_tbl WHERE login = #{login}";
    final static String FIND_BY_ID = "SELECT * FROM user_tbl WHERE id = #{id}";
    final static String UPDATE = "UPDATE user_tbl SET name = #{id}, login = #{login}, password = #{password}, role = #{role} WHERE id = #{id}";
    final static String REMOVE_BY_LOGIN = "DELETE FROM user_tbl WHERE login = #{login}";
    final static String FIND_ALL = "SELECT * FROM user_tbl";

    @Select(FIND_ALL)
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "login", column = "login"),
            @Result(property = "password", column = "password"),
            @Result(property = "role", column = "role")
    })
    List<User> getList();

    @Select(FIND_BY_LOGIN)
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "login", column = "login"),
            @Result(property = "password", column = "password"),
            @Result(property = "role", column = "role")
    })
    User findByLogin(String login);

    @Select(FIND_BY_ID)
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "login", column = "login"),
            @Result(property = "password", column = "password"),
            @Result(property = "role", column = "role")
    })
    User findById(String id);

    @Insert(INSERT)
//    @Options(useGeneratedKeys = true, keyProperty = "id")
    void save(User object);

    @Update(UPDATE)
    void update(User user);

    @Delete(REMOVE_BY_LOGIN)
    void removeByLogin(String login);
}
