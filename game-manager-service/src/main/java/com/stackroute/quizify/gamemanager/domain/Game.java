package com.stackroute.quizify.gamemanager.domain;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Data
@Document(collection="games")
public class Game {

    @Id
    private long id;
    private String name;
    private Category category;
    private Topic topic;
    private int playCount;
    private int numOfQuestion;
    private List<Question> questions;
    private Admin admin;
    private String level;


//    @Override
//    public String toString() {
//        return "Game{" +
//                "id='" + id + '\'' +
//                ", name='" + name + '\'' +
//                ", category=" + category +
//                ", playcount=" + playcount +
//                ", quesNum=" + quesNum +
//                ", questions=" + questions +
//                ", admin=" + admin +
//                ", topic=" + topic +
//                ", level='" + level + '\'' +
//                '}';
//    }

}
