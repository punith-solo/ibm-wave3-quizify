package com.stackroute.quizify.recommendationservice.service;

import com.stackroute.quizify.kafka.domain.Game;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GameService {

    public List<Game> getAll();

    public Game getone(long gameId);

    public Game create(Game game);

    public Game delete(long gameId);

    public Game update(Game game);
}
