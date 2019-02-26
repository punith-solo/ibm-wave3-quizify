package com.stackroute.quizify.recommendationservice.service;

import com.stackroute.quizify.kafka.domain.User;
import com.stackroute.quizify.recommendationservice.domain.LikesGenre;

import java.util.List;

public interface LikesGenreService {

    List<LikesGenre> getAllRelationships();

    String createRelationship(User user);
}
