package com.stackroute.quizify.recommendationservice.domain;


import com.stackroute.quizify.kafka.domain.Game;
import com.stackroute.quizify.kafka.domain.User;
import lombok.Data;
import org.neo4j.ogm.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Data
@RelationshipEntity(type="Played")
public class Played {


        @Id
        @GeneratedValue
        private String id;

        private List<String> quizzes=new ArrayList<>();
        @Property
        private int score;
        @StartNode
        private User user;
        @EndNode
        private Game game;
}
