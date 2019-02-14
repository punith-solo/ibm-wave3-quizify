package com.stackroute.quizify.questionmanager.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "categories")
@Data
public class Category {
    @Id
    private String id;
    private String name;
    private List<Topic> topics;
    private Admin admin;
}
