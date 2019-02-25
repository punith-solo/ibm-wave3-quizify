package com.stackroute.quizify.recommendationservice.domain;

import com.stackroute.quizify.kafka.domain.Topic;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.sql.Timestamp;

@Data
    public class Search {

        @Id
        private int gameId;
        private String gameName;
        private String imageUrl;
        private String description;
        private String level;
        private Timestamp duration;
        private int likes;
        private int gamesPlayed;
        private String genre;
        private String category;
        private Topic topic;

//
//    @Id
//    private Long gameId;
//    private String gameName;
//    private int gamesPlayed;
//    private String level;
//    private String imageUrl;
//    private String description;
//    private Timestamp duration;
//    private int likes;
//    private int noOfQuestions;
    }

