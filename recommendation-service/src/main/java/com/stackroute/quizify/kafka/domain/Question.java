package com.stackroute.quizify.kafka.domain;

import com.stackroute.quizify.recommendationservice.domain.Category;
import com.stackroute.quizify.recommendationservice.domain.Genre;
import com.stackroute.quizify.recommendationservice.domain.Tag;
import com.stackroute.quizify.recommendationservice.domain.Topic;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
public class Question {
    @Id
    private long id;
    private Category category;
    private Topic topic;
    private Genre genre;
    private Tag tag;
    private String level;
    private String type;
    private String statement;
    private List<String> options;
    private String correctAnswer;
    private String playerAnswer;
}
