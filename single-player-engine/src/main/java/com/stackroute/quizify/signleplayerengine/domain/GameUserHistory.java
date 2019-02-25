package com.stackroute.quizify.signleplayerengine.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;


@Data
public class GameUserHistory {

    User user;
    Game game;
}
