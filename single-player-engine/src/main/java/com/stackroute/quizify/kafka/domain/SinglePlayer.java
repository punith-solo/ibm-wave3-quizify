package com.stackroute.quizify.kafka.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class SinglePlayer {

    private String playerId;
    private Game game;

}
