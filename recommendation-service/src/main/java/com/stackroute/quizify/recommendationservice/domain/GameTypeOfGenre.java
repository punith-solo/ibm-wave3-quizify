package com.stackroute.quizify.recommendationservice.domain;

import com.stackroute.quizify.kafka.domain.Game;
import lombok.Data;
import org.neo4j.ogm.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Data
@RelationshipEntity(type = "type_of")
public class GameTypeOfGenre {
    @Id
    @GeneratedValue
    private String id;

    @StartNode
    private Game game;
    @EndNode
    private Genre genre;
}
