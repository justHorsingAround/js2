package com.codecool.Dao;

import com.codecool.Model.Poem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface IPoemDao {

    public List<Poem> findAllPoems() throws SQLException;
    public Poem assemblePoem(ResultSet resultSet) throws SQLException;
    public List<Poem> findPoemsTitleByUserId(int id) throws SQLException;
}
