package com.codecool.Dao;

import com.codecool.Model.Poem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PoemDao extends AbstractDao implements IPoemDao {
    public PoemDao(Connection connection) {
        super(connection);
    }

    public List<Poem> findAllPoems() throws SQLException {
        List<Poem> poems = new ArrayList<>();
        String sql = "SELECT * FROM poems;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    poems.add(assemblePoem(resultSet));

                }
            }
        }
        return poems;
    }

    public List<Poem> findPoemsTitleByUserId(int id) throws SQLException {
        List<Poem> poems = new ArrayList<>();
        String sql = "SELECT title, poems.id FROM poems JOIN users ON 1 = poems.poet_id GROUP BY title, poems.id ORDER BY title ASC";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            //preparedStatement.setInt(1, id);
            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    poems.add(assemblePoem(resultSet));

                }
            }
        }
        return poems;
    }


    public Poem assemblePoem(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        int poetId = resultSet.getInt("poet_id");
        String title = resultSet.getString("title");
        String text = resultSet.getString("poem");
        String date = resultSet.getString("release_date");
        return new Poem(id, poetId, title, text, date);
    }
}
