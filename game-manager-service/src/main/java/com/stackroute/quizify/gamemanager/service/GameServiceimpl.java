package com.stackroute.quizify.gamemanager.service;

import com.stackroute.quizify.gamemanager.domain.Game;
import com.stackroute.quizify.gamemanager.exception.GameAlreadyExists;
import com.stackroute.quizify.gamemanager.exception.GameNotFound;
import com.stackroute.quizify.gamemanager.producer.GameProducer;
import com.stackroute.quizify.gamemanager.repository.GameRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameServiceimpl implements GameService {

    final String topic = "game";
    final String bootStrapServer = "localhost:9092";

    private static Logger log = LoggerFactory.getLogger(GameServiceimpl.class);

    private GameRepository gameRepository;


@Autowired
GameServiceimpl(GameRepository gameRepository){

this.gameRepository=gameRepository;
 }

 @Override
 public Game saveGame(Game game) throws GameAlreadyExists{
     Optional optional = gameRepository.findById(game.getName());
     if (optional.isPresent())
         throw new GameAlreadyExists("Game already exists!");
     else
         return GameProducer.produce(gameRepository.save(game), bootStrapServer, topic);

 }

    @Override
    public Game deleteGame(Game game) throws GameNotFound {
        Optional<Game> optional = gameRepository.findById(game.getName());
        log.info("check event+++++++" + optional);
        if (optional.isPresent()) {
            gameRepository.deleteById(game.getName());
            System.out.println("Id is" + game.getName());
            return GameProducer.produce(game, bootStrapServer, topic);
        } else {
            throw new GameNotFound("Game not Found");
        }
    }

    @Override
    public Game updateGame(Game updatedGame) throws GameNotFound{

    if(gameRepository.existsById(updatedGame.getName())){

        return GameProducer.produce(gameRepository.save(updatedGame), bootStrapServer, topic);
    }
    else
        throw new GameNotFound("Game not found");

    }

    @Override
    public Game getGame(String gameName) throws GameNotFound {
        if (gameRepository.existsById(gameName))
        {
            return gameRepository.findById(gameName).get();
        }
        else
            throw new GameNotFound("Game Not Found");
    }

    @Override
    public List<Game> findAllGames(String categoryName, String topicName) throws GameNotFound {
        List<Game> gameList = gameRepository.getAllGames(categoryName, topicName);

        if (gameList.isEmpty())
            throw new GameNotFound("No Game Found!");
        else
            return gameList;
    }

    @Override
    public List<Game> searchGame(String gameName) throws GameNotFound {
        List<Game> gameList = gameRepository.searchGames(gameName);

        if (gameList.isEmpty())
            throw new GameNotFound("No Game Found!");
        else
            return gameList;
    }

}
