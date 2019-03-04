package com.stackroute.quizify.recommendationservice.serviceImpl;

import com.stackroute.quizify.recommendationservice.domain.Games;
import com.stackroute.quizify.recommendationservice.domain.Played;
import com.stackroute.quizify.recommendationservice.domain.SinglePlayers;
import com.stackroute.quizify.recommendationservice.domain.Users;
import com.stackroute.quizify.recommendationservice.repository.PlayedRelationshipRepository;
import com.stackroute.quizify.recommendationservice.service.PlayedRelationshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayedRelationshipServiceImpl implements PlayedRelationshipService {

    PlayedRelationshipRepository playedRelationshipRepository;


    @Autowired
    public PlayedRelationshipServiceImpl(PlayedRelationshipRepository playedRelationshipRepository) {
        this.playedRelationshipRepository = playedRelationshipRepository;
    }

    @Override
    public List<Played> getAllRelationships() {
        return playedRelationshipRepository.getAllRelationships();
    }

    @Override
    public Played createRelationship(SinglePlayers singlePlayers) {
        long userId= singlePlayers.getUserId();
        System.out.println(" user ------------------------- /n " + userId);
        long gameId= singlePlayers.getGameId();
        System.out.println("game-------------------------------/n"+gameId);
        return playedRelationshipRepository.createRelationship(userId,gameId);
    }

}
