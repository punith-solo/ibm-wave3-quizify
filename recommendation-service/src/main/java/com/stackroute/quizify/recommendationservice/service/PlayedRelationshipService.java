package com.stackroute.quizify.recommendationservice.service;

import com.stackroute.quizify.recommendationservice.domain.Played;
import com.stackroute.quizify.recommendationservice.domain.SinglePlayers;

import java.util.List;


public interface PlayedRelationshipService {

    List<Played> getAllRelationships();

    Played createRelationship(SinglePlayers singlePlayers);

}
