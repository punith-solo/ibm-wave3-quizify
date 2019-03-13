package com.stackroute.quizify.recommendationservice.controller;

import com.stackroute.quizify.recommendationservice.domain.LikesGenre;
import com.stackroute.quizify.recommendationservice.domain.User;
import com.stackroute.quizify.recommendationservice.service.LikesGenreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/rest/neo4j/likesgenre")
@Api(description = "Operations on User likes genre Relationships")
public class LikesGenreController {
    private LikesGenreService likesGenreService;

    @Autowired
    public LikesGenreController(LikesGenreService likesGenreService) {
        this.likesGenreService = likesGenreService;
    }

    @ApiOperation("Get all relationships of user likes genre")
    @GetMapping("/")
    public List<LikesGenre> getAll(){
        return likesGenreService.getAllRelationships();
    }

    @ApiOperation("Create a relationship of user likes genre")
    @PostMapping("/")
    public String create(@RequestBody User user){
        return likesGenreService.createRelationship(user);
    }

}
