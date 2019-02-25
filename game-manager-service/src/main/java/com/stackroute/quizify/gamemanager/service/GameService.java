package com.stackroute.quizify.gamemanager.service;

import com.stackroute.quizify.gamemanager.domain.Game;
import com.stackroute.quizify.gamemanager.exception.GameAlreadyExists;
import com.stackroute.quizify.gamemanager.exception.GameNotFound;

import java.util.List;


public interface GameService {

   Game saveGame(Game game) throws GameAlreadyExists;

   Game deleteGame(Game game) throws GameNotFound;

   Game updateGame(Game game) throws GameNotFound;

   Game getGame(String getName) throws GameNotFound;

   List<Game> findAllGames(String categoryName, String topicName)throws GameNotFound;

   List<Game> searchGame(String gameName)throws GameNotFound;

}
