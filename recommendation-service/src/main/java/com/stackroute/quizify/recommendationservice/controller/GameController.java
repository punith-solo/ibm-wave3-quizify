package com.stackroute.quizify.recommendationservice.controller;

import com.stackroute.quizify.kafka.domain.Game;
import com.stackroute.quizify.recommendationservice.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/neo4j/game")
public class GameController {

    private GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/")
    public List<Game> getAll(){
        return gameService.getAll();
    }

    @GetMapping("/id")
    public Game getOne(@RequestParam("GameId") long GameId){
        return gameService.getone(GameId);
    }

    @PostMapping("/")
    public Game create(@RequestBody Game Game){
        return gameService.create(Game);
    }

    @DeleteMapping("/")
    public Game delete(@RequestParam("GameId") long GameId){
        System.out.println(GameId);
        return gameService.delete(GameId);
    }

    @PutMapping("/")
    public Game update(@RequestBody Game Game)
    {
        return gameService.update(Game);
    }

}
