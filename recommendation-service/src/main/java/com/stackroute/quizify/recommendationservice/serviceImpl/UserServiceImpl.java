package com.stackroute.quizify.recommendationservice.serviceImpl;

import com.stackroute.quizify.kafka.domain.User;
import com.stackroute.quizify.recommendationservice.repository.UserRepository;
import com.stackroute.quizify.recommendationservice.service.UserService;
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
    public List<User> getAll() {
        return userRepository.getAllNodes();
    }

    @Override
    public User getone(long userId) {
        return userRepository.getNode(userId);
    }

    @Override
    public User create(User user) {
        long id=user.getUserId();
        String name=user.getUserName();
        String gender=user.getGender();
        return userRepository.createNode(id,name,gender);
    }
    @Override
    public User delete(long userId) {
        return userRepository.deleteNode(userId);
    }

    @Override
    public User update(User user) {
        long id=user.getUserId();
        String name=user.getUserName();
        String gender=user.getGender();
        return userRepository.updateNode(id,name,gender);
    }
}
