package com.stackroute.quizify.recommendationservice.controller;


import com.stackroute.quizify.recommendationservice.domain.LikesTopic;
import com.stackroute.quizify.recommendationservice.domain.User;
import com.stackroute.quizify.recommendationservice.service.LikesTopicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/rest/neo4j/likestopic")
@Api(description = "Operations on User likes topic Relationships")
public class LikesTopicController {

    LikesTopicService likesTopicService;

    @Autowired
    public LikesTopicController(LikesTopicService likesTopicService) {
        this.likesTopicService = likesTopicService;
    }

    @ApiOperation("Get all relationships of user likes topic")
    @GetMapping("/")
    public List<LikesTopic> getAll(){
        return likesTopicService.getAllRelationships();
    }

    @ApiOperation("Create a relationship of user likes topic")
    @PostMapping("/")
    public List<LikesTopic> create(@RequestBody User user){
        return likesTopicService.createRelationship(user);
    }
}

