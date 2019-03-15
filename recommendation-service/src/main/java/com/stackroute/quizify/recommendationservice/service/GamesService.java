package com.stackroute.quizify.recommendationservice.service;

import com.stackroute.quizify.recommendationservice.domain.Game;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GamesService {

    public List<Game> getAll();

    public Game getone(long gameId);

    public Game create(Game game);

    public Game delete(long gamed);

    public Game update(Game game);

    List<Game> getMostPlayed();

    List<Game> getAllRelatedGamesOfAGenre(long genreId);

    List<Game> getAllRelatedGamesOfATopic(long topicId);

    List<Game> getAllGamesPlayedByAUser(long userId);

    List<Game> getAllGamesLikedByAUser(long userId);

    List<Game> getAllGamesByLevel(String level,int playerScore, int totalPoints);
}
