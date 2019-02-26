package com.stackroute.quizify.kafka.domain;

import com.stackroute.quizify.kafka.domain.Game;
import com.stackroute.quizify.kafka.domain.User;
import lombok.Data;

@Data
public class SinglePlayer {
    private Game game;
    private User user;
}
