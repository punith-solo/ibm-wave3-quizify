package com.stackroute.quizify.kafka.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.List;


@Document(collection = "UserDoc")
@Data
public class User {
    @Id
    private long id;
    private String name;
    private String password;
    private String emailId;
    private List<Topic> topics;
    private List<Genre> genres;
    private String gender;
}
