package com.stackroute.quizify.recommendationservice.service;

import com.stackroute.quizify.kafka.domain.Topic;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TopicService {

    public List<Topic> getAll();
}
