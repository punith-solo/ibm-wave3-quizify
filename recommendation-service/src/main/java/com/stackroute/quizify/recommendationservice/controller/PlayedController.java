package com.stackroute.quizify.recommendationservice.controller;

import com.stackroute.quizify.recommendationservice.domain.Played;
import com.stackroute.quizify.recommendationservice.domain.SinglePlayer;
import com.stackroute.quizify.recommendationservice.service.PlayedRelationshipService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/rest/neo4j/played")

@Api(description = "Operations on User played game Relationships")
public class PlayedController {

    PlayedRelationshipService playedRelationshipService;

    @Autowired
    public PlayedController(PlayedRelationshipService playedRelationshipService) {
        this.playedRelationshipService = playedRelationshipService;
    }
    @ApiOperation("Get all relationships of user played game")
    @GetMapping("/")
    public List<Played> getAll(){
        return playedRelationshipService.getAllRelationships();
    }

    @ApiOperation("Create a relationship of user played game")
    @PostMapping("/")
    public Played Create(@RequestBody SinglePlayer singlePlayer){
        return playedRelationshipService.createRelationship(singlePlayer);
    }
}
