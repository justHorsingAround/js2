package com.codecool.Dao;

import com.codecool.Model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface IUserDao {

    List<User> findAllUsers() throws SQLException;
    User assembleUser(ResultSet resultSet) throws SQLException;

}
