package com.stackroute.quizify.recommendationservice.controller;

import com.stackroute.quizify.recommendationservice.domain.GameIsATopic;
import com.stackroute.quizify.recommendationservice.domain.GameTypeOfGenre;
import com.stackroute.quizify.recommendationservice.domain.Games;
import com.stackroute.quizify.recommendationservice.service.GameIsATopicService;
import com.stackroute.quizify.recommendationservice.service.GameTypeOfGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/neo4j/gametypeofgenre")
public class GameTypeOfGenreController {

        GameTypeOfGenreService gameTypeOfGenreService;

        @Autowired
        public GameTypeOfGenreController(GameTypeOfGenreService gameTypeOfGenreService) {
            this.gameTypeOfGenreService = gameTypeOfGenreService;
        }

        @GetMapping("/")
        public List<GameTypeOfGenre> getAll(){
            return gameTypeOfGenreService.getAllRelationships();
        }

        @PostMapping("/")
        public GameTypeOfGenre create(@RequestBody Games games){
            return gameTypeOfGenreService.createRelationship(games);
        }

}
