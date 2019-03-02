package com.stackroute.quizify.recommendationservice.service;

import com.stackroute.quizify.recommendationservice.domain.GameTypeOfGenre;
import com.stackroute.quizify.recommendationservice.domain.Games;

import java.util.List;

public interface GameTypeOfGenreService {
    List<GameTypeOfGenre> getAllRelationships();

    GameTypeOfGenre createRelationship(Games game);
}
