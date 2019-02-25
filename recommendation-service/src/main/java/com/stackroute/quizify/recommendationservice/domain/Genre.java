package com.stackroute.quizify.recommendationservice.domain;

import com.stackroute.quizify.kafka.domain.Game;

import java.util.List;

public class Genre {
    private Long genreId;
    private String genreName;
    private String imageUrl;
    private List<Game> game;
}
