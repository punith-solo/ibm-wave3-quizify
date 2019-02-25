package com.stackroute.quizify.kafka.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.List;


@Document(collection = "UserDoc")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    private String userName;
    private String password;
    private String confirmPassword;
    private String emailId;
    private List<String> interests;
    private String gender;
}
