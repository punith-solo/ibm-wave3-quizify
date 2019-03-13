package com.stackroute.quizify.recommendationservice.controller;

import com.stackroute.quizify.recommendationservice.domain.Game;
import com.stackroute.quizify.recommendationservice.service.GamesService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/rest/neo4j/game")
public class GamesController {

    private GamesService gamessService;

    @Autowired
    public GamesController(GamesService gamessService) {
        this.gamessService = gamessService;
    }

    @ApiOperation("Get all games")
    @GetMapping("/")
    public List<Game> getAll(){
        return gamessService.getAll();
    }

    @ApiOperation("Get most played games")
    @GetMapping("/mostplayed")
    public List<Game> getMostPlayed(){
        return gamessService.getMostPlayed();
    }

    @ApiOperation("Get games of a Genre")
    @GetMapping("/{genreId}")
    public List<Game> getAllRelatedGamesOfAGenre(@PathVariable("genreId") long genreId) {
        return gamessService.getAllRelatedGamesOfAGenre(genreId);
    }

    @ApiOperation("Get games of a Topic")
    @GetMapping("/{topicId}")
    public List<Game> getAllRelatedGamesOfATopic(@PathVariable("topicId") long topicId) {
        return gamessService.getAllRelatedGamesOfATopic(topicId);
    }

    @ApiOperation("Get games played by a user")
    @GetMapping("/games/{userId}")
    public List<Game> getAllGamesPlayedByAUser(@PathVariable("userId") long userId) {
        return gamessService.getAllGamesPlayedByAUser(userId);
    }

    @ApiOperation("Get games liked by a user")
    @GetMapping("/likes/{userId}")
    public List<Game> getAllGamesLikedByAUser(@PathVariable("userId") long userId) {
        return gamessService.getAllGamesLikedByAUser(userId);
    }

    @ApiOperation("Get a game by id")
    @GetMapping("/id")
    public Game getOne(@RequestParam("GamesId") long GamesId){
        return gamessService.getone(GamesId);
    }

    @ApiOperation("Create a game")
    @PostMapping("/")
    public Game create(@RequestBody Game Game){
        return gamessService.create(Game);
    }

    @ApiOperation("delete a game by id")
    @DeleteMapping("/")
    public Game delete(@RequestParam("GamesId") long GamesId){
        System.out.println(GamesId);
        return gamessService.delete(GamesId);
    }

    @ApiOperation("Update a game by Game object")
    @PutMapping("/")
    public Game update(@RequestBody Game Game)
    {
        return gamessService.update(Game);
    }

}
