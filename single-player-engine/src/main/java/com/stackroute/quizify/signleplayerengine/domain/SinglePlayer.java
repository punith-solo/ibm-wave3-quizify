package com.stackroute.quizify.signleplayerengine.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "players")
@Data
public class SinglePlayer {
    @Id
    private long id;
    private Game game;
    private List<User> users;
}
