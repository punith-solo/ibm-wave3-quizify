package com.stackroute.quizify.recommendationservice.service;

import com.stackroute.quizify.kafka.domain.SinglePlayer;
import com.stackroute.quizify.recommendationservice.domain.Played;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PlayedRelationshipService {

    List<Played> getAllRelationships();

    Played createRelationship(SinglePlayer singlePlayer);

}
