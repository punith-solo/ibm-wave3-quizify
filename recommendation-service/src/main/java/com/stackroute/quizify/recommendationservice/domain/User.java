package com.stackroute.quizify.recommendationservice.domain;


import com.stackroute.quizify.dto.model.GameDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

import java.util.List;


@NodeEntity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id @GeneratedValue
    private long id;
    @Property
    private String name;
    private List<Topic> topics;
    private List<Genre> genres;
    @Property
    private String gender;
    @Property
    private List<Game> playedGames;

//    public long getId() {
//        return id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public List<Topic> getTopics() {
//        return topics;
//    }
//
//    public List<Genre> getGenres() {
//        return genres;
//    }
//
//    public String getGender() {
//        return gender;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setTopics(List<Topic> topics) {
//        this.topics = topics;
//    }
//
//    public void setGenres(List<Genre> genres) {
//        this.genres = genres;
//    }
//
//    public void setGender(String gender) {
//        this.gender = gender;
//    }
}


//    CREATE (Peter:User{userName: 'Peter N', gender: 'male'}) CREATE (Sam:User {userName: 'Sam Sheldon', gender: 'male'}) CREATE (Ryan:User {userName: 'Ryan A', gender: 'male'})

