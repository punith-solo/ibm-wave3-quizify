package com.stackroute.quizify.kafka;

import com.stackroute.quizify.kafka.domain.Game;
import com.stackroute.quizify.kafka.domain.SinglePlayer;
import com.stackroute.quizify.kafka.domain.User;
import com.stackroute.quizify.recommendationservice.domain.*;
import com.stackroute.quizify.recommendationservice.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;


@Component
public class Consumer {

    private GamesService gamesService;
    private UserService userService;
    private PlayedRelationshipService playedRelationshipService;

    private  Games games= new Games();
    private Users users=new Users();
    private SinglePlayers singlePlayers=new SinglePlayers();

    @Autowired
    public Consumer(GamesService gamesService, UserService userService, PlayedRelationshipService playedRelationshipService) {
        this.gamesService = gamesService;
        this.userService = userService;
        this.playedRelationshipService = playedRelationshipService;
    }

    @KafkaListener(topics = "games", groupId = "recommendation-game-consumer", containerFactory = "kafkaListenerGameContainerFactory")
    public void receiveGame(@Payload Game payload) {
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Game Received To Recommendation : ");
        System.out.println(payload);
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");

        games.setId(payload.getId());
        games.setName(payload.getName());
        games.setRules(payload.getRules());
        games.setTimeDuration(payload.getTimeDuration());
        games.setPlayCount(payload.getPlayCount());
        games.setImageUrl(payload.getImageUrl());
        games.setLevel(payload.getLevel());
        games.setLiked(payload.getLiked());
        games.setNumOfQuestion(payload.getNumOfQuestion());
        games.setCategory(payload.getCategory());
        games.setGenre(payload.getGenre());
        games.setTopic(payload.getTopic());
        games.setTag(payload.getTag());
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(games.toString());

        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
        gamesService.create(games);

    }

    @KafkaListener(topics = "users", groupId = "recommendation-users-consumer", containerFactory = "kafkaListenerUserContainerFactory")
    public void receiveUser(@Payload User payload) {
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Users Received To Recommendation : ");
        System.out.println(payload);
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");

        users.setId(payload.getId());
        users.setName(payload.getName());
        users.setGender(payload.getGender());
        users.setTopics(payload.getTopics());
        users.setGenres(payload.getGenres());
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------\n"+users.toString());

        userService.create(users);
    }
//
//    @KafkaListener(topics = "singlePlayers", groupId = "recommendation-single-player-consumer", containerFactory = "kafkaListenerSinglePlayerContainerFactory")
//    public void receiveSinglePlayer(@Payload SinglePlayer payload) {
//        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
//        System.out.println("SinglePlayers Received To Recommendation : ");
//        System.out.println(payload);
//        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
//
//        singlePlayers.setGameId(payload.getGame().getId());
//        singlePlayers.setUserId(payload.getUser().getId());
//
//        System.out.println(" gameId  "+singlePlayers.getGameId()  +"  userId   "+singlePlayers.getUserId());
//
//        playedRelationshipService.createRelationship(singlePlayers);
//    }

}

