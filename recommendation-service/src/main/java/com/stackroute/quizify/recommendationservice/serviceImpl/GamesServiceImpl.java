package com.stackroute.quizify.recommendationservice.serviceImpl;

import com.stackroute.quizify.recommendationservice.domain.GameIsATopic;
import com.stackroute.quizify.recommendationservice.domain.Games;
import com.stackroute.quizify.recommendationservice.repository.GamesRepository;
import com.stackroute.quizify.recommendationservice.service.GameIsATopicService;
import com.stackroute.quizify.recommendationservice.service.GameTypeOfGenreService;
import com.stackroute.quizify.recommendationservice.service.GamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GamesServiceImpl implements GamesService {

    GamesRepository gamesRepository;

    @Autowired
    private GameIsATopicService gameIsATopicService;

    @Autowired
    private GameTypeOfGenreService gameTypeOfGenreService;
    @Autowired
    public GamesServiceImpl(GamesRepository gamesRepository) {
        this.gamesRepository = gamesRepository;
    }

    @Override
    public List<Games> getAll() {
        return gamesRepository.getAllNodes();
    }

    @Override
    public Games getone(long gamesId) {
        return gamesRepository.getNode(gamesId);
    }

    @Override
    public Games create(Games games) {
        long id=games.getId();
        String name=games.getName();
        Games games1=gamesRepository.createNode(id,name);
        gameIsATopicService.createRelationship(games);
        gameTypeOfGenreService.createRelationship(games);
        return games1;
    }

    @Override
    public Games delete(long gamesId) {
        return gamesRepository.deleteNode(gamesId);
    }

    @Override
    public Games update(Games games) {
        long id=games.getId();
        String name=games.getName();
        return gamesRepository.updateNode(id,name);
    }

    @Override
    public List<Games> getMostPlayed() {
        return gamesRepository.getMostPlayed();
    }
}
