package com.codecool.Services;

import com.codecool.Model.User;
import com.codecool.Services.Exceptions.InvalidUserException;

public interface IUserService {
    User loginUser(String emailInput, String passwordInput) throws InvalidUserException;
}
