package com.stackroute.quizify.recommendationservice.controller;

import com.stackroute.quizify.recommendationservice.domain.LikesGenre;
import com.stackroute.quizify.recommendationservice.service.LikesGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/neo4j/likesgenre")
public class LikesGenreController {
    private LikesGenreService likesGenreService;

    @Autowired
    public LikesGenreController(LikesGenreService likesGenreService) {
        this.likesGenreService = likesGenreService;
    }

    @GetMapping("/")
    public List<LikesGenre> getAll(){
        return likesGenreService.getAllRelationships();
    }


//    @PostMapping("/")
//    public LikesGenre create(@RequestParam("userId") long userId, @RequestParam("topicId") long topicId){
//        return likesGenreService.createRelationship(userId, topicId);
//    }
//
}
