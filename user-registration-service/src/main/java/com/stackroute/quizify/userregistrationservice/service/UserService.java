package com.stackroute.quizify.userregistrationservice.service;

import com.stackroute.quizify.dto.model.UserDTO;
import com.stackroute.quizify.userregistrationservice.domain.User;
import com.stackroute.quizify.userregistrationservice.exceptions.UserAlreadyExistException;
import com.stackroute.quizify.userregistrationservice.exceptions.UserNameExistException;
import com.stackroute.quizify.userregistrationservice.exceptions.UserNotFoundException;

import java.util.List;

public interface UserService {

     User saveUser(User user) throws UserAlreadyExistException, UserNameExistException;
     User getUser(long id) throws UserNotFoundException;
     List<User> getAllUsers()throws UserNotFoundException;
     User updateUser(User user) throws UserNotFoundException, UserNameExistException;
     User deleteUser(long id) throws UserNotFoundException;

}
