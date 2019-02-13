package com.company.repository;

import com.company.api.UserRepositoryDB;
import com.company.dao.ConnectionSupplier;
import com.company.model.User;
import com.company.util.UserRole;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepositoryDBImpl implements UserRepositoryDB {
    private final static String INSERT = "INSERT INTO user_tbl (id, name, login, password, role) VALUES (?, ?, ?, ?, ?)";
    private final static String FIND_BY_LOGIN = "SELECT * FROM user_tbl WHERE login = ?";
    private final static String FIND_BY_ID = "SELECT * FROM user_tbl WHERE id = ?";
    private final static String UPDATE = "UPDATE user_tbl SET name = ?, login = ?, password = ?, role = ? WHERE id = ?";
    private final static String REMOVE_BY_LOGIN = "DELETE FROM user_tbl WHERE login = ?";
    private final static String FIND_ALL = "SELECT * FROM user_tbl";
    private final ConnectionSupplier connectionSupplier;

    public UserRepositoryDBImpl(ConnectionSupplier connectionSupplier) {
        this.connectionSupplier = connectionSupplier;
    }

    @Override
    @SneakyThrows
    public boolean save(User object) {
        try (Connection connection = connectionSupplier.getConnection()) {
            PreparedStatement preparedStatement =  connection.prepareStatement(INSERT);
            preparedStatement.setString(1, object.getId());
            preparedStatement.setString(2, object.getName());
            preparedStatement.setString(3, object.getLogin());
            preparedStatement.setString(4, object.getPassword());
            preparedStatement.setString(5, object.getRole().name());

            int i = preparedStatement.executeUpdate();
            return i > 0;
        }
    }

    @Override
    @SneakyThrows
    public Optional<User> findByLogin(String login) {
        try(Connection connection = connectionSupplier.getConnection()) {
            PreparedStatement preparedStatement =  connection.prepareStatement(FIND_BY_LOGIN);
            preparedStatement.setString(1, login);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getString("id"));
                user.setName(resultSet.getString("name"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setRole(UserRole.valueOf(resultSet.getString("role")));
                return Optional.of(user);
            } else {
                return Optional.empty();
            }
        }
    }

    @Override
    @SneakyThrows
    public Optional<User> findById(String id) {
        try(Connection connection = connectionSupplier.getConnection()) {
            PreparedStatement preparedStatement =  connection.prepareStatement(FIND_BY_ID);
            preparedStatement.setString(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getString("id"));
                user.setName(resultSet.getString("name"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setRole(UserRole.valueOf(resultSet.getString("role")));
                return Optional.of(user);
            } else {
                return Optional.empty();
            }
        }
    }

    @Override
    @SneakyThrows
    public boolean update(User object) {
        try(Connection connection = connectionSupplier.getConnection()) {
            PreparedStatement preparedStatement =  connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, object.getName());
            preparedStatement.setString(2, object.getLogin());
            preparedStatement.setString(3, object.getPassword());
            preparedStatement.setString(4, object.getRole().name());
            preparedStatement.setString(5, object.getId());

            int i = preparedStatement.executeUpdate();
            return i > 0;
        }
    }

    @Override
    @SneakyThrows
    public boolean removeByLogin(String login) {
        try(Connection connection = connectionSupplier.getConnection()) {
            PreparedStatement preparedStatement =  connection.prepareStatement(REMOVE_BY_LOGIN);
            preparedStatement.setString(1, login);

            int i = preparedStatement.executeUpdate();
            return i > 0;
        }
    }

    @Override
    @SneakyThrows
    public List<User> getList() {
        List<User> list = new ArrayList<>();
        try(Connection connection = connectionSupplier.getConnection()) {
            PreparedStatement preparedStatement =  connection.prepareStatement(FIND_ALL);

            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getString("id"));
                user.setName(resultSet.getString("name"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setRole(UserRole.valueOf(resultSet.getString("role")));
                list.add(user);
            }
        }
        return list;
    }
}