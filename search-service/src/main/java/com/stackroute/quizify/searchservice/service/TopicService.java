package com.stackroute.quizify.searchservice.service;

import com.stackroute.quizify.searchservice.domain.Topics;
import com.stackroute.quizify.searchservice.exception.TopicAlreadyExistsException;
import com.stackroute.quizify.searchservice.exception.TopicDoesNotExistsException;

import java.util.List;

/*
 * This "TopicService" Interface is used to declare all the necessary services/methods
 * which are must be implemented by the Implementing Class (TopicServiceImpl).
 */

public interface TopicService {
    Topics saveTopic(Topics topic) throws TopicAlreadyExistsException;
//    List<Topic> getAllTopicByName(String topicName) throws TopicDoesNotExistsException;
    List<Topics> getAllTopicByStartsWith(String topicName) throws TopicDoesNotExistsException;
}
