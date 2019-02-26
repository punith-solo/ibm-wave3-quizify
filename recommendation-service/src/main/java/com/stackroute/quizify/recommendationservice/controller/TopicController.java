package com.stackroute.quizify.recommendationservice.controller;

import com.stackroute.quizify.kafka.domain.Topic;
import com.stackroute.quizify.recommendationservice.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/")
    public List<Topic> getAll(){
        return topicService.getAll();
    }
}


