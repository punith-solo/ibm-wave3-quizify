package com.stackroute.quizify.dto.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
public class QuestionDTO {
    @Id
    private long id;
    private CategoryDTO categoryDTO;
    private TopicDTO topicDTO;
    private GenreDTO genreDTO;
    private TagDTO tagDTO;
    private String level;
    private String type;
    private String statement;
    private List<String> options;
    private String correctAnswer;
    private String playerAnswer;
}
