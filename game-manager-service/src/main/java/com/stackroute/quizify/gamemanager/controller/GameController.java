package com.stackroute.quizify.gamemanager.controller;


import com.stackroute.quizify.gamemanager.domain.Game;
import com.stackroute.quizify.gamemanager.domain.Question;
import com.stackroute.quizify.gamemanager.exception.GameAlreadyExists;
import com.stackroute.quizify.gamemanager.exception.GameNotFound;
import com.stackroute.quizify.gamemanager.service.GameService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1")
@Api(description = "Game Manager Services")
public class GameController {

    private ResponseEntity<?> responseEntity;
    private GameService gameService;

    @Autowired
    private RestTemplate restTemplate;
    private GameController(GameService gameService)
    {
        this.gameService=gameService;
    }

    @ApiOperation(value = "Add Games")
    @PostMapping("/games/game")
    public ResponseEntity<?> saveGame(@RequestBody Game game) throws GameAlreadyExists {

        try {
            return new ResponseEntity<Game>(gameService.saveGame(game), HttpStatus.OK);
        }
        catch(GameAlreadyExists e)
        {
           return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT) ;
        }
    }
    @ApiOperation(value = "Delete Game")
    @DeleteMapping("/games/game")
    public ResponseEntity<?> deleteGame(@RequestBody Game game) throws GameNotFound
    {
        try {
            return new ResponseEntity<Game>(gameService.deleteGame(game), HttpStatus.OK);
        }
        catch(GameNotFound e){
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND) ;
        }

    }
    @ApiOperation(value = "Updating Game")
    @PutMapping("/games/game")
    public ResponseEntity<?> updateGame(@RequestBody Game updatedGame) throws GameNotFound{

        try {
            return new ResponseEntity<Game>(gameService.updateGame(updatedGame), HttpStatus.OK);
        }
        catch (GameNotFound e)
        {
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND) ;
        }

    }

    @ApiOperation(value = "Get Game")
    @GetMapping(value = "/games/game/{gameName}")
    public ResponseEntity<?> getGame(@PathVariable String gameName)
    {
        try
        {
            Game game = gameService.getGame(gameName);
            String url = "http://13.232.243.68:8001/api/v1/categories/" +
                    game.getCategory().getName()+"/"+
                    game.getTopic().getName()+"/"+
                    game.getLevel()+"/"+
                    game.getNumOfQuestion();
            List<Question> questionList = new ArrayList<>();
            questionList = restTemplate.getForObject(url, questionList.getClass());

            game.setQuestions(questionList);

            return new ResponseEntity<Game>(game,HttpStatus.OK) ;
        }
        catch (GameNotFound e) {
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND) ;
        }
//        final String url = "http://localhost:8001/api/v1//categories/{categoryName}/{topicName}/{level}/{numOfQuestions}";
//        Game result = restTemplate.getForObject(url, Game.class);
//        responseEntity = new ResponseEntity("get game question", HttpStatus.CREATED);
//        return result;
    }
}
