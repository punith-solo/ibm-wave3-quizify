package com.stackroute.quizify.recommendationservice.controller;

import com.stackroute.quizify.recommendationservice.domain.Genre;
import com.stackroute.quizify.recommendationservice.service.GenreService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/rest/neo4j/genre")
public class GenreController {

    GenreService genreService;

    @Autowired
    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @ApiOperation("Get all genres")
        @GetMapping("/")
    public List<Genre> getAll(){
        return genreService.getAll();
    }

    @ApiOperation("Get genres by category id")
    @GetMapping("/{categoryId}")
    public List<Genre> getGenresByCategory(@PathVariable("categoryId") long categoryId){
        return genreService.getGenresByCategory(categoryId);
    }
}
