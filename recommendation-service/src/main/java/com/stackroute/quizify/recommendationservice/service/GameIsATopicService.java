package com.stackroute.quizify.recommendationservice.service;


import com.stackroute.quizify.recommendationservice.domain.GameIsATopic;
import com.stackroute.quizify.recommendationservice.domain.Games;

import java.util.List;

public interface GameIsATopicService {
    List<GameIsATopic> getAllRelationships();

    GameIsATopic createRelationship(Games games);
}
