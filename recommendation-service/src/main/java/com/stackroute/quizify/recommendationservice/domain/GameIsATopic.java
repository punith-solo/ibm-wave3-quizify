package com.stackroute.quizify.recommendationservice.domain;

import com.stackroute.quizify.kafka.domain.Game;
import com.stackroute.quizify.kafka.domain.Topic;
import lombok.Data;
import org.neo4j.ogm.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Data
@RelationshipEntity(type = "is_a")
public class GameIsATopic {
    @Id
    @GeneratedValue
    private String id;

    @StartNode
    private Game game;
    @EndNode
    private Topic topic;
}
