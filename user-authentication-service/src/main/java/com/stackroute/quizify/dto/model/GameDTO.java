package com.stackroute.quizify.dto.model;


import lombok.Data;
import org.springframework.data.annotation.Id;

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
    private int totalPoints;
    private int playerScore;
}
