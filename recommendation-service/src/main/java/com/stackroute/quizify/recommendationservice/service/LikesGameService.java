package com.stackroute.quizify.recommendationservice.service;

import com.stackroute.quizify.recommendationservice.domain.LikesGame;

import java.util.List;

public interface LikesGameService {
    List<LikesGame> getAllRelationships();

    LikesGame createRelationship(String userName, String gameName);

    LikesGame deleteRelationship(String userName, String gameName);

}
