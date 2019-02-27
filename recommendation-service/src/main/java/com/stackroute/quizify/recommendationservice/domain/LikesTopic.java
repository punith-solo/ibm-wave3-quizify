package com.stackroute.quizify.recommendationservice.domain;


import lombok.Data;
import org.neo4j.ogm.annotation.*;

@Data
@RelationshipEntity(type = "LikesTopic")
public class LikesTopic {
    @Id
    @GeneratedValue
    private String id;

    @StartNode
    private Users user;
    @EndNode
    private Topics topic;
}
