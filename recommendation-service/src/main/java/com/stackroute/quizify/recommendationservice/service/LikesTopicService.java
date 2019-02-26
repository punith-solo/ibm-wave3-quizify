package com.stackroute.quizify.recommendationservice.service;

import com.stackroute.quizify.kafka.domain.User;
import com.stackroute.quizify.recommendationservice.domain.LikesTopic;

import java.util.List;


public interface LikesTopicService {

    List<LikesTopic> getAllRelationships();

    LikesTopic createRelationship(User user);



}
