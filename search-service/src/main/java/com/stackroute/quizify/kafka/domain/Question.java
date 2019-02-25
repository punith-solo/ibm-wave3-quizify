package com.stackroute.quizify.kafka.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
public class Question {
    @Id
    private long id;
    private Category category;
    private Topic topic;
    private String tag;
    private String genre;
    private String level;
    private String type;
    private String statement;
    private List<String> options;
    private String answer;
    private String playerAnswer;
    private String timeStamp;
    private Admin admin;
}
