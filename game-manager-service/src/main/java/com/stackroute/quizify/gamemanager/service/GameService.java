package com.stackroute.quizify.gamemanager.service;

import com.stackroute.quizify.gamemanager.exception.GameAlreadyExistsException;
import com.stackroute.quizify.gamemanager.exception.GameNotFoundException;
import com.stackroute.quizify.gamemanager.domain.Game;
import com.stackroute.quizify.gamemanager.exception.NoGamesFoundException;

import java.util.List;


public interface GameService {

   Game saveGame(Game game) throws GameAlreadyExistsException;

   Game deleteGame(long id) throws GameNotFoundException;

   Game updateGame(Game game) throws GameNotFoundException;

   Game findGameById(long id) throws GameNotFoundException;


   List<Game> getAllGames() throws NoGamesFoundException;
   List<Game> getAllGamesByTopic(String topicName) throws NoGamesFoundException;
   List<Game> getAllGamesByGenre(String genreName) throws NoGamesFoundException;

}
