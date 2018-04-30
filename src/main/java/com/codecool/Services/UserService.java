package com.codecool.Services;

import com.codecool.Dao.IUserDao;
import com.codecool.Model.User;
import com.codecool.Services.Exceptions.InvalidUserException;

import java.sql.SQLException;
import java.util.List;


public class UserService implements IUserService {
    private final IUserDao userDao;


    public UserService(IUserDao userDao) {
        this.userDao = userDao;
    }

    public User loginUser(String emailInput, String passwordInput) throws InvalidUserException {
        List<User> registeredUsers = null;
        User currentLogin = new User(emailInput, passwordInput);
        try {
            registeredUsers = userDao.findAllUsers();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new InvalidUserException("Database error");
        }
        for (User usr: registeredUsers) {
            if(usr.equals(currentLogin)){
                return usr;

            }
        }
        throw new InvalidUserException("Wrong user name or password");
    }
}
