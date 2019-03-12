package com.stackroute.quizify.recommendationservice.controller;

import com.stackroute.quizify.recommendationservice.domain.LikesGame;
import com.stackroute.quizify.recommendationservice.service.LikesGameService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/rest/neo4j/likesgame")
public class LikesGameController {

    LikesGameService likesGameService;

    @Autowired
    public LikesGameController(LikesGameService likesGameService) {
        this.likesGameService = likesGameService;
    }

    @ApiOperation("Get all relationships of user likes game")
    @GetMapping("/")
    public List<LikesGame> getAll(){
        return likesGameService.getAllRelationships();
    }

    @ApiOperation("Create relationship of user likes game")
    @PostMapping("/")
    public LikesGame create(@RequestParam("userId") long userId, @RequestParam("gameId") long gameId){
        return likesGameService.createRelationship(userId, gameId);
    }

    @ApiOperation("Delete relationship of user likes game")
    @DeleteMapping("/")
    public LikesGame delete(@RequestParam("userId") long userId, @RequestParam("gameId") long gameId){
        return likesGameService.deleteRelationship(userId, gameId);
    }

}
