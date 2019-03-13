package com.stackroute.quizify.recommendationservice.serviceImpl;

import com.stackroute.quizify.recommendationservice.domain.Game;
import com.stackroute.quizify.recommendationservice.domain.User;
import com.stackroute.quizify.recommendationservice.repository.UserRepository;
import com.stackroute.quizify.recommendationservice.service.LikesGenreService;
import com.stackroute.quizify.recommendationservice.service.LikesTopicService;
import com.stackroute.quizify.recommendationservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
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
    public List<User> getAll() {
        return userRepository.getAllNodes();
    }

    @Override
    public User getone(long userId) {
        return userRepository.getNode(userId);
    }

    @Override
    public User create(User user) {
        long id= user.getId();
        String name= user.getName();
        String gender= user.getGender();
//        List<Game> playedGames=user.getPlayedGames();
        log.info("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        log.info("user node to be created -> id: "+id+"  name "+name+" gender  "+gender);
//        User user1 =userRepository.createNode(id,name,gender,playedGames);
        User user1 =userRepository.createNode(id,name,gender);
        log.info("============================================================control to liketopic service===================================================================================");
        likesTopicService.createRelationship(user);
        log.info("============================================================control to likegenre service===================================================================================");
        likesGenreService.createRelationship(user);
        return user1;
    }
    @Override
    public User delete(long userId) {
        return userRepository.deleteNode(userId);
    }

    @Override
    public User update(User user) {
        long id= user.getId();
        String name= user.getName();
        String gender= user.getGender();
        return userRepository.updateNode(id,name,gender);
    }
}
