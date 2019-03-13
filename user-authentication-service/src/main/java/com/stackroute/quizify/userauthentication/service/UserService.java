package com.stackroute.quizify.userauthentication.service;

import com.stackroute.quizify.userauthentication.domain.User;
import com.stackroute.quizify.userauthentication.exceptions.UserAlreadyExistsException;

import java.util.List;

public interface UserService
{
    User saveUser(User user) throws UserAlreadyExistsException; //users ADDED

    List<User> getAllUsers();  ///RETRIEVE users

    User findByUserIdAndPassword(String username,String password);
}
