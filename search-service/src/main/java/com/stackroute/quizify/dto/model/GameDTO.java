package com.stackroute.quizify.dto.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
public class GameDTO {
    @Id
    private long id;
    private String name;
    private Category category;
    private Topic topic;
    private Genre genre;
    private Tag tag;
    private String level;
    private String imageUrl;
    private int numOfQuestion;
    private List<Question> questions;
    private int timeDuration;
    private int liked;
    private int playCount;
    private List<String> rules;
}
