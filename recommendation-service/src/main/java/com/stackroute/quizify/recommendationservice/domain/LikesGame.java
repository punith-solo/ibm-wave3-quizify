package com.stackroute.quizify.recommendationservice.domain;

import lombok.Data;
import org.neo4j.ogm.annotation.*;

@Data
@RelationshipEntity("LikesGame")
public class LikesGame {
    @Id
    @GeneratedValue
    private long id;

    @StartNode
    private Users user;
    @EndNode
    private Games game;
}
