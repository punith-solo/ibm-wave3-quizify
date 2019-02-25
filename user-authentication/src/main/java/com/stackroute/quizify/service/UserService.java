package com.stackroute.quizify.service;

import com.stackroute.quizify.domain.User;
import com.stackroute.quizify.exceptions.UserNameNotFoundException;

import java.util.List;

public interface UserService
{
    public User saveUser(User user) throws UserNameNotFoundException; //users ADDED

    public List<User> getAllUsers();  ///RETRIEVE users

    public User findByUserIdAndPassword(String username,String password);
}
