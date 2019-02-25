package com.stackroute.quizify.userservice.service;

import com.stackroute.quizify.userservice.domain.User;

import com.stackroute.quizify.userservice.exceptions.UserAlreadyExistException;
import com.stackroute.quizify.userservice.exceptions.UserNotFoundException;

import java.util.List;

public interface UserService {

    public User saveUser(User user) throws  UserAlreadyExistException, UserNotFoundException;
    public List<User> getAllUsers();
    public User updateUser(User user) throws UserNotFoundException;
    public boolean deleteUser(Long id);

}
