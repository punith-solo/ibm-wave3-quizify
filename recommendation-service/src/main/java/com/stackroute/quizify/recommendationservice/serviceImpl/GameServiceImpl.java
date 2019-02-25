package com.stackroute.quizify.recommendationservice.serviceImpl;

import com.stackroute.quizify.kafka.domain.Game;
import com.stackroute.quizify.recommendationservice.repository.GameRepository;
import com.stackroute.quizify.recommendationservice.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImpl implements GameService {

    GameRepository gameRepository;

    @Autowired
    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public List<Game> getAll() {
        return gameRepository.getAllNodes();
    }

    @Override
    public Game getone(long gameId) {
        return gameRepository.getNode(gameId);
    }

    @Override
    public Game create(Game game) {
        long id=game.getId();
        String name=game.getName();
        return gameRepository.createNode(id,name);
    }

    @Override
    public Game delete(long gameId) {
        return gameRepository.deleteNode(gameId);
    }

    @Override
    public Game update(Game game) {
        long id=game.getId();
        String name=game.getName();
        return gameRepository.updateNode(id,name);
    }
}
