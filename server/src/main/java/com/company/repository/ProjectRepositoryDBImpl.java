package com.company.repository;

import com.company.api.ProjectMapper;
import com.company.api.RepositoryDB;
import com.company.api.UserRepositoryDB;
import com.company.dao.ConnectionSupplier;
import com.company.model.Project;
import com.company.model.User;
import lombok.SneakyThrows;
import org.apache.ibatis.session.SqlSession;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProjectRepositoryDBImpl implements RepositoryDB<String, Project> {
    private final static String INSERT = "INSERT INTO project_tbl (id, name, description, userId) VALUES (?, ?, ?, ?)";
    private final static String FIND_BY_NAME = "SELECT * FROM project_tbl WHERE name = ?";
    private final static String FIND_BY_ID = "SELECT * FROM project_tbl WHERE id = ?";
    private final static String UPDATE = "UPDATE project_tbl SET name = ?, description = ?, userId = ? WHERE id = ?";
    private final static String REMOVE_BY_NAME = "DELETE FROM project_tbl WHERE name = ?";
    private final static String FIND_ALL = "SELECT * FROM project_tbl";
    private final ConnectionSupplier connectionSupplier;
    private final UserRepositoryDB userRepositoryDB;

    public ProjectRepositoryDBImpl(ConnectionSupplier connectionSupplier, UserRepositoryDB userRepositoryDB) {
        this.connectionSupplier = connectionSupplier;
        this.userRepositoryDB = userRepositoryDB;
    }

    @Override
    public boolean save(Project object) {
        SqlSession session = connectionSupplier.getSession();
        ProjectMapper mapper = session.getMapper(ProjectMapper.class);
        mapper.save(object);
        session.commit();
        session.close();
        return true;
    }

    @Override
    public Optional<Project> findByName(String name) {
        SqlSession session = connectionSupplier.getSession();
        ProjectMapper mapper =  session.getMapper(ProjectMapper.class);
        Project project = mapper.findByName(name);
        session.commit();
        session.close();
        return Optional.of(project);
    }

    @Override
    public Optional<Project> findById(String id) {
        SqlSession session = connectionSupplier.getSession();
        ProjectMapper mapper = session.getMapper(ProjectMapper.class);
        Project project = mapper.findById(id);
        session.commit();
        session.close();
        return Optional.of(project);
    }

    @Override
    public boolean update(Project object) {
        SqlSession session = connectionSupplier.getSession();
        ProjectMapper mapper = session.getMapper(ProjectMapper.class);
        mapper.update(object);
        session.commit();
        session.close();
        return true;
    }

    @Override
    public boolean removeByName(String name) {
        SqlSession session = connectionSupplier.getSession();
        ProjectMapper mapper = session.getMapper(ProjectMapper.class);
        mapper.removeByName(name);
        session.commit();
        session.close();
        return true;
    }

    @Override
    public List<Project> getList() {
        SqlSession session = connectionSupplier.getSession();
        ProjectMapper mapper = session.getMapper(ProjectMapper.class);
        List<Project> list = mapper.getList();
        session.commit();
        session.close();
        return list;
    }

//    @Override
//    @SneakyThrows
//    public boolean save(Project object) {
//        try (Connection connection = connectionSupplier.getConnection()) {
//            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
//            preparedStatement.setString(1, object.getId());
//            preparedStatement.setString(2, object.getName());
//            preparedStatement.setString(3, object.getDescription());
//            preparedStatement.setString(4, object.getUser().getId());
//            int i = preparedStatement.executeUpdate();
//            return i > 0;
//        }
//    }
//
//    @Override
//    @SneakyThrows
//    public Optional<Project> findByName(String name) {
//        try (Connection connection = connectionSupplier.getConnection()) {
//            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_NAME);
//            preparedStatement.setString(1, name);
//
//            ResultSet resultSet = preparedStatement.executeQuery();
//            if (resultSet.next()) {
//                Project project = new Project();
//                project.setId(resultSet.getString("id"));
//                project.setName(resultSet.getString("name"));
//                project.setDescription(resultSet.getString("description"));
//                Optional<User> optionalUser = userRepositoryDB.findById(resultSet.getString("userId"));
//                optionalUser.ifPresent(project::setUser);
//                return Optional.of(project);
//            } else {
//                return Optional.empty();
//            }
//        }
//    }
//
//    @Override
//    @SneakyThrows
//    public Optional<Project> findById(String id){
//        try(Connection connection = connectionSupplier.getConnection()) {
//            PreparedStatement preparedStatement =  connection.prepareStatement(FIND_BY_ID);
//            preparedStatement.setString(1, id);
//
//            ResultSet resultSet = preparedStatement.executeQuery();
//            if (resultSet.next()) {
//                Project project = new Project();
//                project.setId(resultSet.getString("id"));
//                project.setName(resultSet.getString("name"));
//                project.setDescription(resultSet.getString("description"));
//                Optional<User> optionalUser = userRepositoryDB.findById(resultSet.getString("userId"));
//                optionalUser.ifPresent(project::setUser);
//                return Optional.of(project);
//            } else {
//                return Optional.empty();
//            }
//        }
//    }
//
//    @Override
//    @SneakyThrows
//    public boolean update(Project object) {
//        try(Connection connection = connectionSupplier.getConnection()) {
//            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
//            preparedStatement.setString(1, object.getName());
//            preparedStatement.setString(2, object.getDescription());
//            preparedStatement.setString(3, object.getUser().getId());
//            preparedStatement.setString(4, object.getId());
//
//            int i = preparedStatement.executeUpdate();
//            return i > 0;
//        }
//    }
//
//    @Override
//    @SneakyThrows
//    public boolean removeByName(String name) {
//        try(Connection connection = connectionSupplier.getConnection()) {
//            PreparedStatement preparedStatement = connection.prepareStatement(REMOVE_BY_NAME);
//            preparedStatement.setString(1, name);
//
//            int i = preparedStatement.executeUpdate();
//            return i > 0;
//        }
//    }
//
//    @Override
//    @SneakyThrows
//    public List<Project> getList() {
//        List<Project> list = new ArrayList<>();
//        try(Connection connection = connectionSupplier.getConnection()) {
//            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);
//
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            while (resultSet.next()) {
//                Project project = new Project();
//                project.setId(resultSet.getString("id"));
//                project.setName(resultSet.getString("name"));
//                project.setDescription(resultSet.getString("description"));
//                Optional<User> optionalUser = userRepositoryDB.findById(resultSet.getString("userId"));
//                optionalUser.ifPresent(project::setUser);
//                list.add(project);
//            }
//        }
//        return list;
//    }
}
