package com.stackroute.quizify.dto.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
public class GameDTO {
    @Id
    private long id;
    private String name;
    private CategoryDTO category;
    private TopicDTO topic;
    private GenreDTO genre;
    private String level;
    private String imageUrl;
    private int numOfQuestion;
    private List<QuestionDTO> questions;
    private int timeDuration;
    private int liked;
    private int playCount;
    private List<String> rules;
    private int pointPerQuestion;
    private int totalPoints;
    private int playerScore;
}
