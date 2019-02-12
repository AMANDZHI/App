package com.company.repository;

import com.company.api.RepositoryDB;
import com.company.dao.ConnectionSupplier;
import com.company.model.Project;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class ProjectRepositoryDBImpl implements RepositoryDB<String, Project> {
    private final String INSERT = "INSERT INTO project_tbl (id, name, description, userId) VALUES (?, ?, ?, ?)";
    private final String FIND_BY_NAME = "SELECT * FROM project_tbl WHERE name = ?";
    private final String UPDATE = "UPDATE project_tbl SET name = ?, description = ?, userId = ? WHERE id = ?";
    private final String REMOVE_BY_NAME = "DELETE FROM project_tbl WHERE name = ?";
    private final String FIND_ALL = "SELECT * FROM project_tbl";
    private ConnectionSupplier connectionSupplier;

    public ProjectRepositoryDBImpl(ConnectionSupplier connectionSupplier) {
        this.connectionSupplier = connectionSupplier;
    }

    @Override
    public boolean save(Project object) {
        try(Connection connection = connectionSupplier.getConnection()) {
            PreparedStatement preparedStatement =  connection.prepareStatement(INSERT);
            preparedStatement.setString(1, object.getId());
            preparedStatement.setString(2, object.getName());
            preparedStatement.setString(3, object.getDescription());
            preparedStatement.setString(4, object.getUser().getId());

            int i = preparedStatement.executeUpdate();
            if (i > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Optional<Project> findByName(String name) {
        try(Connection connection = connectionSupplier.getConnection()) {
            PreparedStatement preparedStatement =  connection.prepareStatement(FIND_BY_NAME);
            preparedStatement.setString(1, name);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Project project = new Project();
                project.setId(resultSet.getString("id"));
                project.setName(resultSet.getString("name"));
                project.setDescription(resultSet.getString("description"));
                project.setUser(resultSet.getString("userId"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Project update(Project object) {
        return null;
    }

    @Override
    public boolean removeByName(String name) {
        return false;
    }

    @Override
    public List<Project> getList() {
        return null;
    }
}
