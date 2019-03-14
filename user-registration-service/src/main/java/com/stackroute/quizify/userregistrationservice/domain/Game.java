package com.stackroute.quizify.userregistrationservice.domain;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
public class Game {
    @Id
    private long id;
    private String name;
    private Category category;
    private Topic topic;
    private Genre genre;
    private String level;
    private String imageUrl;
    private int totalPoints;
    private int playerScore;
}
