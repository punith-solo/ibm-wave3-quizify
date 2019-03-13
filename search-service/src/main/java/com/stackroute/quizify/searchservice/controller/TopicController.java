package com.stackroute.quizify.searchservice.controller;

import com.stackroute.quizify.searchservice.domain.Topics;
import com.stackroute.quizify.searchservice.exception.TopicDoesNotExistsException;
import com.stackroute.quizify.searchservice.service.TopicService;
import com.stackroute.quizify.searchservice.exception.TopicAlreadyExistsException;
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
@Api(description="Search by Topic")
public class TopicController {
    private TopicService topicService;

    @Autowired
    public TopicController(TopicService topicService){
        this.topicService = topicService;
    }

    @ApiOperation(value = "Save Genre")
    @PostMapping("/search/topic")
    public ResponseEntity<?> saveTopic(@RequestBody Topics topics) throws TopicAlreadyExistsException {
        return new ResponseEntity<Topics>(topicService.saveTopic(topics), HttpStatus.OK);
    }

    @ApiOperation(value = "Search Topic By Starts With")
    @GetMapping("/search/topics/{topicName}")
    public ResponseEntity<?>searchTopicByStartsWith(@PathVariable String topicName) throws TopicDoesNotExistsException {
        return new ResponseEntity<List<Topics>>(topicService.getAllTopicByStartsWith(topicName), HttpStatus.OK);
    }
}
