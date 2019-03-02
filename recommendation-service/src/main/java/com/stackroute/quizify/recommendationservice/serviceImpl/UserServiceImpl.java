package com.stackroute.quizify.recommendationservice.serviceImpl;

import com.stackroute.quizify.recommendationservice.domain.Users;
import com.stackroute.quizify.recommendationservice.repository.UserRepository;
import com.stackroute.quizify.recommendationservice.service.LikesGenreService;
import com.stackroute.quizify.recommendationservice.service.LikesTopicService;
import com.stackroute.quizify.recommendationservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    LikesTopicService likesTopicService;

    LikesGenreService likesGenreService;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, LikesTopicService likesTopicService, LikesGenreService likesGenreService) {
        this.userRepository = userRepository;
        this.likesTopicService=likesTopicService;
        this.likesGenreService=likesGenreService;
    }

    @Override
    public List<Users> getAll() {
        return userRepository.getAllNodes();
    }

    @Override
    public Users getone(long userId) {
        return userRepository.getNode(userId);
    }

    @Override
    public Users create(Users users) {
        long id= users.getId();
        String name= users.getName();
        String gender= users.getGender();
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println("user node to be created -> id: "+id+"name"+name+"gender"+gender);
        Users users1=userRepository.createNode(id,name,gender);
        System.out.println("============================================================control to liketopic service===================================================================================");
        likesTopicService.createRelationship(users);
        System.out.println("============================================================control to likegenre service===================================================================================");
        likesGenreService.createRelationship(users);
        return users1;
    }
    @Override
    public Users delete(long userId) {
        return userRepository.deleteNode(userId);
    }

    @Override
    public Users update(Users users) {
        long id= users.getId();
        String name= users.getName();
        String gender= users.getGender();
        return userRepository.updateNode(id,name,gender);
    }
}
