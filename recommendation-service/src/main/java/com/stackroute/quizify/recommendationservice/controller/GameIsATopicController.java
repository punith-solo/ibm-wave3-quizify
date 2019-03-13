package com.stackroute.quizify.recommendationservice.controller;

import com.stackroute.quizify.recommendationservice.domain.Game;
import com.stackroute.quizify.recommendationservice.domain.GameIsATopic;
import com.stackroute.quizify.recommendationservice.service.GameIsATopicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/rest/neo4j/gameisatopic")
@Api(description = "Operations on Game is a topic Relationships")
public class GameIsATopicController {

    GameIsATopicService gameIsATopicService;

    @Autowired
    public GameIsATopicController(GameIsATopicService gameIsATopicService) {
        this.gameIsATopicService = gameIsATopicService;
    }

    @ApiOperation("Get all relatioships of game and topic")
    @GetMapping("/")
    public List<GameIsATopic> getAll(){
        return gameIsATopicService.getAllRelationships();
    }

    @ApiOperation("Create a relationship between game and topic")
    @PostMapping("/")
    public GameIsATopic create(@RequestBody Game game){
        return gameIsATopicService.createRelationship(game);
    }
}
