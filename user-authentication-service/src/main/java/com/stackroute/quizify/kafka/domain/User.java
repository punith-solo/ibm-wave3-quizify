package com.stackroute.quizify.kafka.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import java.util.List;

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
