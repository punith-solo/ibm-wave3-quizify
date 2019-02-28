package com.stackroute.quizify.recommendationservice.domain;


import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

import java.util.List;


@NodeEntity
@Data
public class Users {
    @Id @GeneratedValue
    private long id;
    private String name;
    private List<Topic> topic;
    private List<Genre> genres;
    private String gender;
}


//    CREATE (Peter:Users{userName: 'Peter N', gender: 'male'}) CREATE (Sam:Users {userName: 'Sam Sheldon', gender: 'male'}) CREATE (Ryan:Users {userName: 'Ryan A', gender: 'male'})

