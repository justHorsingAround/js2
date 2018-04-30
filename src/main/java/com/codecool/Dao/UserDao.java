package com.codecool.Dao;


import com.codecool.Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public final class UserDao extends AbstractDao implements IUserDao {


    public UserDao(Connection connection) {
        super(connection);
    }

    public List<User> findAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        String sql = "SELECT id, email, nickname, password FROM users;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            try(ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    users.add(assembleUser(resultSet));
                }
            }
        return users;
        }
    }

    public User assembleUser(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String email = resultSet.getString("email");
        String name = resultSet.getString("nickname");
        String passw = resultSet.getString("password");
        return new User(id, email, name, passw);
    }
}
