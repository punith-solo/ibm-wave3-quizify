package com.stackroute.quizify.service;

import com.stackroute.quizify.domain.User;
import com.stackroute.quizify.exceptions.UserNameNotFoundException;
import com.stackroute.quizify.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    private UserRepository userRepo;

    @Autowired
    public UserServiceImpl(UserRepository repo) {
        this.userRepo = repo;
    }


    @Override
    public User findByUserIdAndPassword(String username, String password) {
        return userRepo.findByUsernameAndPassword(username, password);
    }


    @Override
    public User saveUser(User user)throws UserNameNotFoundException
    {
        if(userRepo.existsById(user.getUsername())){
            throw new UserNameNotFoundException("User already exists!!");

        }
        User userSaved = userRepo.save(user);
        return userSaved;

    }


    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }



}
