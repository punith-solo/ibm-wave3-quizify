package com.stackroute.quizify.recommendationservice.controller;

import com.stackroute.quizify.recommendationservice.domain.Game;
import com.stackroute.quizify.recommendationservice.domain.GameTypeOfGenre;
import com.stackroute.quizify.recommendationservice.service.GameTypeOfGenreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/rest/neo4j/gametypeofgenre")
@Api(description = "Operations on Game type of Genre Relationships")
public class GameTypeOfGenreController {

        GameTypeOfGenreService gameTypeOfGenreService;

        @Autowired
        public GameTypeOfGenreController(GameTypeOfGenreService gameTypeOfGenreService) {
            this.gameTypeOfGenreService = gameTypeOfGenreService;
        }

    @ApiOperation("Get all relationships between game and genre")
        @GetMapping("/")
        public List<GameTypeOfGenre> getAll(){
            return gameTypeOfGenreService.getAllRelationships();
        }

    @ApiOperation("Create a relationship between game and genre")
        @PostMapping("/")
        public GameTypeOfGenre create(@RequestBody Game game){
            return gameTypeOfGenreService.createRelationship(game);
        }

}
