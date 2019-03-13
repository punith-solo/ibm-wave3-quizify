package com.stackroute.quizify.searchservice.controller;

import com.stackroute.quizify.searchservice.domain.Genres;
import com.stackroute.quizify.searchservice.exception.GenreAlreadyExistsException;
import com.stackroute.quizify.searchservice.service.GenreService;
import com.stackroute.quizify.searchservice.exception.GenreDoesNotExistsException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
@Api(description="Search by Genre")
public class GenreController {
    GenreService genreService;

    @Autowired
    public GenreController(GenreService genreService){
        this.genreService = genreService;
    }

    @ApiOperation(value = "Save Genre")
    @PostMapping("/search/genre")
    public ResponseEntity<?> saveGenre(@RequestBody Genres genres) throws GenreAlreadyExistsException {
        return new ResponseEntity<Genres>(genreService.saveGenre(genres), HttpStatus.OK);

    }

    @ApiOperation(value = "Search Genre By Starts With")
    @GetMapping("/search/genres/{genreName}")
    public ResponseEntity<?>searchGenreByStartsWith(@PathVariable String genreName) throws GenreDoesNotExistsException {
        return new ResponseEntity<List<Genres>>(genreService.getAllGenreByStartsWith(genreName), HttpStatus.OK);
    }
}
