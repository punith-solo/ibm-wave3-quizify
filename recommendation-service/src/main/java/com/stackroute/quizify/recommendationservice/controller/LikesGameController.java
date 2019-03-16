package com.stackroute.quizify.recommendationservice.controller;

import com.stackroute.quizify.recommendationservice.domain.LikesGame;
import com.stackroute.quizify.recommendationservice.service.LikesGameService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/rest/neo4j")
@Api(description = "Operations on User likes game Relationships")
public class LikesGameController {

    LikesGameService likesGameService;

    @Autowired
    public LikesGameController(LikesGameService likesGameService) {
        this.likesGameService = likesGameService;
    }

    @ApiOperation("Get all relationships of user likes game")
    @GetMapping("/likesgame")
    public List<LikesGame> getAll(){
        return likesGameService.getAllRelationships();
    }

    @ApiOperation("Create relationship of user likes game")
    @PostMapping("/likes/user/{userName}/game/{gameId}")
    public LikesGame create(@PathVariable("userName") String userName, @PathVariable("gameId") long gameId){
        return likesGameService.createRelationship(userName, gameId);
    }
//   @ApiOperation("Create relationship of user likes game")
//    @PostMapping("/likes/user/{userName}/game/{gameName}")
//    public LikesGame create(@PathVariable("userName") String userName, @PathVariable("gameName") String gameName){
//        return likesGameService.createRelationship(userName, gameName);
//    }

//    @ApiOperation("Delete relationship of user likes game")
 //   @DeleteMapping("/dislikes/user/{userName}/game/{gameName}")
// public LikesGame delete(@PathVariable("userName") String userName, @PathVariable("gameName") String gameName){
  //      return likesGameService.deleteRelationship(userName, gameName);
    //}

}
