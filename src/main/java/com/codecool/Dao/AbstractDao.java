package com.codecool.Dao;

import javax.servlet.http.HttpServlet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AbstractDao extends HttpServlet {

    final Connection connection;

    public AbstractDao(Connection connection) {
        this.connection = connection;
    }

}
