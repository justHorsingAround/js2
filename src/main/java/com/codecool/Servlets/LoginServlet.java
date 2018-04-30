package com.codecool.Servlets;

import com.codecool.Dao.IUserDao;
import com.codecool.Dao.UserDao;
import com.codecool.Model.User;
import com.codecool.Services.Exceptions.InvalidUserException;
import com.codecool.Services.IUserService;
import com.codecool.Services.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/login")
public final class LoginServlet extends AbstractServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try (Connection connection = getConnection(req.getServletContext())) {

            IUserDao userDao = new UserDao(connection);
            IUserService uService = new UserService(userDao);

            String email = req.getParameter("email");
            if(email == null){
                throw new NullPointerException("Failed to get parameter 'email'");
            }
            String password = req.getParameter("password");
            if(password == null){
                throw new NullPointerException("Failed to get parameter'password");
            }


            User user = uService.loginUser(email, password);
            req.getSession().setAttribute("user", user);

            sendMessage(resp, HttpServletResponse.SC_OK, user);

        } catch (SQLException e) {
            handleSqlError(resp, e);
        } catch (InvalidUserException e) {
            sendMessage(resp, HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
        }

    }
}
