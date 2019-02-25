package com.stackroute.quizify.kafka.domain;


import io.swagger.annotations.ApiModelProperty;

import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

import org.neo4j.ogm.annotation.Property;
import org.springframework.data.annotation.Transient;

import java.util.List;


@NodeEntity
@Data
public class User {
    @Id @GeneratedValue
    private long userId;
    @Property
    private String userName;
    private String password;
    private String confirmPassword;
    private String emailId;
    @Property
    private List<String> interests;
    private List<String> topics;

    @Property
    private String gender;;
}


//    CREATE (Peter:User{userName: 'Peter N', gender: 'male'}) CREATE (Sam:User {userName: 'Sam Sheldon', gender: 'male'}) CREATE (Ryan:User {userName: 'Ryan A', gender: 'male'})

