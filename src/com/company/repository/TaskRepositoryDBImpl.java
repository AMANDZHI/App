package com.company.repository;

import com.company.api.RepositoryDB;
import com.company.dao.ConnectionSupplier;
import com.company.model.Project;
import com.company.model.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TaskRepositoryDBImpl implements RepositoryDB<String, Task> {
    private final static String INSERT = "INSERT INTO task_tbl (id, name, description, projectId) VALUES (?, ?, ?, ?)";
    private final static String FIND_BY_NAME = "SELECT * FROM task_tbl WHERE name = ?";
    private final static String FIND_BY_ID = "SELECT * FROM task_tbl WHERE id = ?";
    private final static String UPDATE = "UPDATE task_tbl SET name = ?, description = ?, projectId = ? WHERE id = ?";
    private final static String REMOVE_BY_NAME = "DELETE FROM task_tbl WHERE name = ?";
    private final static String FIND_ALL = "SELECT * FROM task_tbl";
    private ConnectionSupplier connectionSupplier;
    private RepositoryDB projectRepositoryDB;

    public TaskRepositoryDBImpl(ConnectionSupplier connectionSupplier, RepositoryDB projectRepositoryDB) {
        this.connectionSupplier = connectionSupplier;
        this.projectRepositoryDB = projectRepositoryDB;
    }

    @Override
    public boolean save(Task object) {
        try(Connection connection = connectionSupplier.getConnection()) {
            PreparedStatement preparedStatement =  connection.prepareStatement(INSERT);
            preparedStatement.setString(1, object.getId());
            preparedStatement.setString(2, object.getName());
            preparedStatement.setString(3, object.getDescription());
            preparedStatement.setString(4, object.getProject().getId());

            int i = preparedStatement.executeUpdate();
            return i > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Optional<Task> findByName(String name) {
        try(Connection connection = connectionSupplier.getConnection()) {
            PreparedStatement preparedStatement =  connection.prepareStatement(FIND_BY_NAME);
            preparedStatement.setString(1, name);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Task Task = new Task();
                Task.setId(resultSet.getString("id"));
                Task.setName(resultSet.getString("name"));
                Task.setDescription(resultSet.getString("description"));
                Optional<Project> optionalProject = projectRepositoryDB.findById(resultSet.getString("projectId"));
                optionalProject.ifPresent(Task::setProject);
                return Optional.of(Task);
            } else {
                return Optional.empty();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<Task> findById(String id) {
        try(Connection connection = connectionSupplier.getConnection()) {
            PreparedStatement preparedStatement =  connection.prepareStatement(FIND_BY_ID);
            preparedStatement.setString(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Task Task = new Task();
                Task.setId(resultSet.getString("id"));
                Task.setName(resultSet.getString("name"));
                Task.setDescription(resultSet.getString("description"));
                Optional<Project> optionalProject = projectRepositoryDB.findById(resultSet.getString("projectId"));
                optionalProject.ifPresent(Task::setProject);
                return Optional.of(Task);
            } else {
                return Optional.empty();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public boolean update(Task object) {
        try(Connection connection = connectionSupplier.getConnection()) {
            PreparedStatement preparedStatement =  connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, object.getName());
            preparedStatement.setString(2, object.getDescription());
            preparedStatement.setString(3, object.getProject().getId());
            preparedStatement.setString(4, object.getId());

            int i = preparedStatement.executeUpdate();
            return i > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean removeByName(String name) {
        try(Connection connection = connectionSupplier.getConnection()) {
            PreparedStatement preparedStatement =  connection.prepareStatement(REMOVE_BY_NAME);
            preparedStatement.setString(1, name);

            int i = preparedStatement.executeUpdate();
            return i > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Task> getList() {
        List<Task> list = new ArrayList<>();
        try(Connection connection = connectionSupplier.getConnection()) {
            PreparedStatement preparedStatement =  connection.prepareStatement(FIND_ALL);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Task Task = new Task();
                Task.setId(resultSet.getString("id"));
                Task.setName(resultSet.getString("name"));
                Task.setDescription(resultSet.getString("description"));
                Optional<Project> optionalProject = projectRepositoryDB.findById(resultSet.getString("ProjectId"));
                optionalProject.ifPresent(Task::setProject);
                list.add(Task);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
