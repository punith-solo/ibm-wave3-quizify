package com.stackroute.quizify.gamemanager.service;

import com.stackroute.quizify.gamemanager.exception.GameAlreadyExistsException;
import com.stackroute.quizify.gamemanager.exception.GameNotFoundException;
import com.stackroute.quizify.gamemanager.domain.Game;
import com.stackroute.quizify.gamemanager.exception.NoGamesFoundException;
import com.stackroute.quizify.gamemanager.repository.GameRepository;
import com.stackroute.quizify.kafka.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GameServiceImpl implements GameService {

    private GameRepository gameRepository;
    private Producer producer;


    @Autowired
    public GameServiceImpl(GameRepository gameRepository, Producer producer){

        this.gameRepository=gameRepository;
        this.producer = producer;
     }

     @Override
     public Game saveGame(Game game) throws GameAlreadyExistsException {
         if(this.gameRepository.existsById(game.getId()))
             throw new GameAlreadyExistsException();
         else {
             if(this.gameRepository.findTopByOrderByIdDesc().isEmpty())
                 game.setId(1);
             else
                 game.setId(this.gameRepository.findTopByOrderByIdDesc().get().getId()+1);
             return producer.send(this.gameRepository.save(game));
         }
     }

    @Override
    public Game deleteGame(long gameId) throws GameNotFoundException {
        if(this.gameRepository.existsById(gameId)) {
            Game game = this.gameRepository.findById(gameId);
            this.gameRepository.delete(game);
            return game;
        }
        else
            throw  new GameNotFoundException();
    }

    @Override
    public Game updateGame(Game updatedGame) throws GameNotFoundException {

    if(this.gameRepository.existsById(updatedGame.getId()))
        return producer.send(this.gameRepository.save(updatedGame));
    else
        throw new GameNotFoundException();

    }

    @Override
    public Game findGameById(long id) throws GameNotFoundException {
        if (this.gameRepository.existsById(id))
            return this.gameRepository.findById(id);
        else
            throw new GameNotFoundException();
    }

    @Override
    public List<Game> getAllGames() throws NoGamesFoundException {
        List<Game> games = this.gameRepository.findAll();
        if (games.isEmpty())
            throw new NoGamesFoundException();
        else
            return games;
    }

    @Override
    public List<Game> getAllGamesByTopic(String topicName) throws NoGamesFoundException {
        List<Game> games = this.gameRepository.findGamesByTopic(topicName);
        if (games.isEmpty())
            throw new NoGamesFoundException();
        else
            return games;
    }

    @Override
    public List<Game> getAllGamesByGenre(String genreName) throws NoGamesFoundException {
        List<Game> games = this.gameRepository.findGamesByGenre(genreName);
        if (games.isEmpty())
            throw new NoGamesFoundException();
        else
            return games;
    }
}
