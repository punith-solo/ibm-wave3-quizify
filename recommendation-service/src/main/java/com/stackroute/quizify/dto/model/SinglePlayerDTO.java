package com.stackroute.quizify.dto.model;

import lombok.Data;

@Data
public class SinglePlayerDTO {
    private long playerId;
    private GameDTO game;
}
