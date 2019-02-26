package com.stackroute.quizify.recommendationservice.controller;

import com.stackroute.quizify.recommendationservice.domain.LikesTopic;
import com.stackroute.quizify.recommendationservice.service.LikesTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/neo4j/likestopic")
public class LikesTopicController {

    LikesTopicService likesTopicService;

    @Autowired
    public LikesTopicController(LikesTopicService likesTopicService) {
        this.likesTopicService = likesTopicService;
    }

    @GetMapping("/")
    public List<LikesTopic> getAll(){
        return likesTopicService.getAllRelationships();
    }

//    @GetMapping("/id")
//    public LikesTopic getOne(@RequestParam("LikesTopicId") long LikesTopicId){
//        return likesTopicService.getone(LikesTopicId);
//    }

//    @PostMapping("/")
//    public LikesTopic create(@RequestParam("userId") long userId, @RequestParam("topicId") long topicId){
//        return likesTopicService.createRelationship(userId, topicId);
//    }
//

}
