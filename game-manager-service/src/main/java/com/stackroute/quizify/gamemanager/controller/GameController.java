package com.stackroute.quizify.gamemanager.controller;

import com.stackroute.quizify.gamemanager.exception.GameAlreadyExistsException;
import com.stackroute.quizify.gamemanager.exception.GameNotFoundException;
import com.stackroute.quizify.gamemanager.exception.NoGamesFoundException;
import com.stackroute.quizify.gamemanager.service.GameService;
import com.stackroute.quizify.gamemanager.domain.Game;
import com.stackroute.quizify.gamemanager.domain.Genre;
import com.stackroute.quizify.gamemanager.domain.Topic;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("api/v1")
@Api(description = "Game Manager Service")
public class GameController {

    private GameService gameService;
    private RestTemplate restTemplate;
    private Environment env;

    @Autowired
    private GameController(GameService gameService, RestTemplate restTemplate, Environment env)
    {
        this.gameService=gameService;
        this.restTemplate = restTemplate;
        this.env = env;
    }

    @ApiOperation(value = "Add Games")
    @PostMapping("/games/game")
    public ResponseEntity<?> saveGame(@RequestBody Game game) throws GameAlreadyExistsException {
        return new ResponseEntity<Game>(this.gameService.saveGame(game), HttpStatus.OK);
    }

    @ApiOperation(value = "Delete Game")
    @DeleteMapping("/games/game/{id}")
    public ResponseEntity<?> deleteGame(@PathVariable long id) throws GameNotFoundException {
        return new ResponseEntity<Game>(this.gameService.deleteGame(id), HttpStatus.OK);

    }

    @ApiOperation(value = "Updating Game")
    @PutMapping("/games/game")
    public ResponseEntity<?> updateGame(@RequestBody Game updatedGame) throws GameNotFoundException {
        return new ResponseEntity<Game>(this.gameService.updateGame(updatedGame), HttpStatus.OK);
    }

    @ApiOperation(value = "Get All Games")
    @GetMapping("/games")
    public ResponseEntity<?> getAllGames() throws NoGamesFoundException {
        return new ResponseEntity<List<Game>>(this.gameService.getAllGames(), HttpStatus.OK);
    }

    @ApiOperation(value = "Get All Games by Topic")
    @GetMapping("/games/topic/{topicName}")
    public ResponseEntity<?> getAllGamesByTopic(@PathVariable String topicName) throws NoGamesFoundException {
        return new ResponseEntity<List<Game>>(this.gameService.getAllGamesByTopic(topicName), HttpStatus.OK);
    }

    @ApiOperation(value = "Get All Games by Genre")
    @GetMapping("/games/genre/{genreName}")
    public ResponseEntity<?> getAllGamesByGenre(@PathVariable String genreName) throws NoGamesFoundException {
        return new ResponseEntity<List<Game>>(this.gameService.getAllGamesByGenre(genreName), HttpStatus.OK);
    }


    @ApiOperation(value = "Generate Live Game")
    @GetMapping(value = "/games/game/{id}")
    public ResponseEntity<?> generateLiveGame(@PathVariable long id) throws GameNotFoundException {
        Game liveGame = this.gameService.findGameById(id);
        Topic topic = liveGame.getTopic();
        Genre genre = liveGame.getGenre();
        String level = liveGame.getLevel();
        int numberOfQuestions = liveGame.getNumOfQuestion();
        String url = env.getProperty("current.question-manager.url");
        String checkUrl = url+"check/"+topic.getName()+"/"+genre.getName()+"/"+level+"/"+numberOfQuestions;
        boolean checkResult = restTemplate.getForObject(checkUrl, Boolean.class);
        if(checkResult)
        {
            url += "topic/genre/"+topic.getName()+"/"+genre.getName()+"/"+level+"/"+numberOfQuestions;
            liveGame.setQuestions(restTemplate.getForObject(url, ArrayList.class));
            return new ResponseEntity<Game>(liveGame, HttpStatus.OK);
        }
        else
        {
            liveGame.setQuestions(null);
            return new ResponseEntity<Game>(liveGame, HttpStatus.OK);
        }

    }

}
