package com.stackroute.quizify.userservice.service;

import com.stackroute.quizify.userservice.domain.User;


import com.stackroute.quizify.userservice.exceptions.UserAlreadyExistException;
import com.stackroute.quizify.userservice.exceptions.UserNotFoundException;
import com.stackroute.quizify.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) throws UserAlreadyExistException {
        if (userRepository.existsById(user.getUserId())) {
            throw new UserAlreadyExistException("user already exists");
        }
        User savedUser = userRepository.save(user);
        if (savedUser == null) {
            throw new UserAlreadyExistException("User already exists");
        }
        return savedUser;
    }

    @Override
    public List<User> getAllUsers() {

        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) throws UserNotFoundException {
        if (userRepository.existsById(user.getUserId())) {
            throw new UserNotFoundException("user already exists");
        }
        User savedUser = userRepository.save(user);
        if (savedUser == null) {
            throw new UserNotFoundException("User already exists");
        }
        return savedUser;


    }


    @Override
    public boolean deleteUser(Long id) {
        boolean status = false;
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            status = true;

        }
        return status;
    }
}