package com.stackroute.quizify.questionmanager.domain.sparQL;

import com.stackroute.quizify.questionmanager.domain.Category;
import com.stackroute.quizify.questionmanager.domain.Genre;
import com.stackroute.quizify.questionmanager.domain.Topic;
import lombok.Data;

@Data
public class QuestionDetails {
    private Category category;
    private Topic topic;
    private Genre genre;
    private String type;
    private String level;
}
