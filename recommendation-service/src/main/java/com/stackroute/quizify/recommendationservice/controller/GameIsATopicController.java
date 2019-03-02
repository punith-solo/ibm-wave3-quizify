package com.stackroute.quizify.recommendationservice.controller;

import com.stackroute.quizify.recommendationservice.domain.GameIsATopic;
import com.stackroute.quizify.recommendationservice.domain.Games;
import com.stackroute.quizify.recommendationservice.service.GameIsATopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/neo4j/gameisatopic")
public class GameIsATopicController {

    GameIsATopicService gameIsATopicService;

    @Autowired
    public GameIsATopicController(GameIsATopicService gameIsATopicService) {
        this.gameIsATopicService = gameIsATopicService;
    }

    @GetMapping("/")
    public List<GameIsATopic> getAll(){
        return gameIsATopicService.getAllRelationships();
    }

    @PostMapping("/")
    public GameIsATopic create(@RequestBody Games games){
        return gameIsATopicService.createRelationship(games);
    }
}
