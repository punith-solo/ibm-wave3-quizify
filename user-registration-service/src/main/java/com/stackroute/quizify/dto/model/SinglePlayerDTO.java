package com.stackroute.quizify.dto.model;

import lombok.Data;

@Data
public class SinglePlayerDTO {
    private String playerName;
    private GameDTO game;
}
