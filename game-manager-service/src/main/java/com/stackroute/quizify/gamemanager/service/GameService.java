package com.stackroute.quizify.gamemanager.service;

import com.stackroute.quizify.gamemanager.exception.GameAlreadyExistsException;
import com.stackroute.quizify.gamemanager.exception.GameNotFoundException;
import com.stackroute.quizify.gamemanager.exception.NoGameFoundException;
import com.stackroute.quizify.kafka.domain.Game;

import java.util.List;


public interface GameService {

   Game saveGame(Game game) throws GameAlreadyExistsException;

   Game deleteGame(long gameId) throws GameNotFoundException;

   Game updateGame(Game game) throws GameNotFoundException;

   Game findGameById(long id) throws GameNotFoundException;


   List<Game> getAllGames() throws NoGameFoundException;
   List<Game> getAllGamesByTopic(String topicName) throws NoGameFoundException;
   List<Game> getAllGamesByGenre(String genreName) throws NoGameFoundException;
   List<Game> getAllGamesByTag(String tagName) throws NoGameFoundException;

}
