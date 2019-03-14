package com.stackroute.quizify.searchservice.controller;

import com.stackroute.quizify.searchservice.domain.Game;
import com.stackroute.quizify.searchservice.exception.GenreDoesNotExistsException;
import com.stackroute.quizify.searchservice.exception.NoGamesFoundException;
import com.stackroute.quizify.searchservice.exception.TopicDoesNotExistsException;
import com.stackroute.quizify.searchservice.service.UniversalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
@Api(description="Search Games")
public class UniversalController {
    private UniversalService universalService;

    public UniversalController(UniversalService universalService)
    {
        this.universalService = universalService;
    }

    @ApiOperation(value = "Search Games by any Search key")
    @GetMapping("/search/{searchKey}")
    public ResponseEntity<?> searchTopicByStartsWith(@PathVariable String searchKey) throws NoGamesFoundException, TopicDoesNotExistsException, GenreDoesNotExistsException {
        return new ResponseEntity<List<Game>>(this.universalService.searchGame(searchKey), HttpStatus.OK);
    }

}
