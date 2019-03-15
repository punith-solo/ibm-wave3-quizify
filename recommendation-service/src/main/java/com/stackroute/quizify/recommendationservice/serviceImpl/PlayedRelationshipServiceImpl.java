package com.stackroute.quizify.recommendationservice.serviceImpl;

import com.stackroute.quizify.recommendationservice.domain.Game;
import com.stackroute.quizify.recommendationservice.domain.Played;
import com.stackroute.quizify.recommendationservice.domain.SinglePlayer;
import com.stackroute.quizify.recommendationservice.repository.PlayedRelationshipRepository;
import com.stackroute.quizify.recommendationservice.service.PlayedRelationshipService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
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
    public Played createRelationship(SinglePlayer singlePlayer) {
        String userName= singlePlayer.getPlayerName();
        log.info(" user ------------------------- /n " + userName);
        Game game= singlePlayer.getGame();
        log.info("game-------------------------------/n"+game.getId());
        String  gameId=game.getName();
        int playCount=game.getPlayCount();
        playCount=playCount+1;
        game.setPlayCount(playCount);
        int playerScore=game.getPlayerScore();

        return playedRelationshipRepository.createRelationship(userName,gameId);
    }

}
