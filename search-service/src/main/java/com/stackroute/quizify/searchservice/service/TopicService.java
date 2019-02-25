package com.stackroute.quizify.searchservice.service;

import com.stackroute.quizify.searchservice.domain.Topic;
import com.stackroute.quizify.searchservice.exception.TopicAlreadyExistsException;
import com.stackroute.quizify.searchservice.exception.TopicDoesNotExistsException;

import java.util.List;

/*
 * This "TopicService" Interface is used to declare all the necessary services/methods
 * which are must be implemented by the Implementing Class (TopicServiceImpl).
 */

public interface TopicService {
    Topic saveTopic(Topic topic) throws TopicAlreadyExistsException;
//    List<Topic> getAllTopicByName(String topicName) throws TopicDoesNotExistsException;
    List<Topic> getAllTopicByStartsWith(String topicName) throws TopicDoesNotExistsException;
}
