package com.stackroute.quizify.kafka;

import com.stackroute.quizify.kafka.domain.Game;
import com.stackroute.quizify.kafka.domain.SinglePlayer;
import com.stackroute.quizify.kafka.domain.User;
import com.stackroute.quizify.recommendationservice.domain.Games;
import com.stackroute.quizify.recommendationservice.domain.Users;
import com.stackroute.quizify.recommendationservice.service.GamesService;
import com.stackroute.quizify.recommendationservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;


@Component
public class Consumer {

//    private Game recievedPayload;
@Autowired
    private GamesService gamesService;

@Autowired
private UserService userService;

 private  Games games= new Games();
 private Users users=new Users();
//    public Game getRecievedPayload()
//    {
//        return this.recievedPayload;
//    }

    @KafkaListener(topics = "games-topic", groupId = "recommendation-game-consumer", containerFactory = "kafkaListenerGameContainerFactory")
    public void receiveGame(@Payload Game payload) {
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("Game Received To Recommendation : ");
        System.out.println(payload);
        System.out.println("----------lsdavjkklv"+ payload.getPlayCount());
        System.out.println("--------------------------------------------------------");
        System.out.println("----------"+ payload.getPlayCount());
       // Games games=new Games();
        games.setId(payload.getId());
        games.setName(payload.getName());
        games.setRules(payload.getRules());
        games.setTimeDuration(payload.getTimeDuration());
        games.setPlayCount(payload.getPlayCount());
        System.out.println("----------"+ payload.getPlayCount());
        games.setImageUrl(payload.getImageUrl());
        games.setLevel(payload.getLevel());
        games.setLiked(payload.getLiked());
        games.setNumOfQuestion(payload.getNumOfQuestion());
        System.out.println("------------------------------------------------------");
        System.out.println(games.toString());

        gamesService.create(games);
    }

    @KafkaListener(topics = "users", groupId = "recommendation-users-consumer", containerFactory = "kafkaListenerUserContainerFactory")
    public void receiveUser(@Payload User payload) {
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("Users Received To Recommendation : ");
        System.out.println(payload);
        System.out.println("------------------------------------------------------------------------------");

        users.setId(payload.getId());
        users.setName(payload.getName());
        users.setGender(payload.getGender());
        users.setTopic(payload.getTopics());
        users.setGenres(payload.getGenres());
        System.out.println("----------------------------------------------------------"+users.toString());

        userService.create(users);
    }
//
//    @KafkaListener(topics = "singlePlayers", groupId = "recommendation-single-player-consumer", containerFactory = "kafkaListenerSinglePlayerContainerFactory")
//    public void receiveSinglePlayer(@Payload SinglePlayer payload) {
//        System.out.println("-----------------------------------------------------------------------------------------");
//        System.out.println("SinglePlayer Received To Recommendation : ");
//        System.out.println(payload);
//
//    }

}

