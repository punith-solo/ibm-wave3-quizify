package com.stackroute.quizify.recommendationservice.controller;

import com.stackroute.quizify.recommendationservice.domain.Topics;
import com.stackroute.quizify.recommendationservice.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/neo4j/topic")
public class TopicController {

    private TopicService topicService;

    @Autowired
    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @GetMapping("/{categoryId}")
    public List<Topics> getAllTopicforCategory(@PathVariable("categoryId") long categoryId){
        return topicService.getAllTopicsforCategory(categoryId);
    }

    @GetMapping("/")
    public List<Topics> getAll(){
        return topicService.getAll();
    }
}


