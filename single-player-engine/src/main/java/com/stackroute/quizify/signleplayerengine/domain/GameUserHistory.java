package com.stackroute.quizify.signleplayerengine.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;


@Data
public class GameUserHistory {
@Id
    User user;
}
