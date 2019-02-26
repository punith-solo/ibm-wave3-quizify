package com.stackroute.quizify.kafka.domain;


import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

import java.util.List;

@NodeEntity
@Data
public class Game {

        @Id @GeneratedValue
        public long id;
        @Property
        private String name;
        private Category category;
        @Property
        private Topic topic;
        private int playCount;
        private int numOfQuestion;
        private String imageUrl;
        private List<Question> questions;
        private Admin admin;
        private String level;
        @Property
        private String genre;
        private String tag;
        private int liked;
        private int played;
        private int timestamp;
        private String rules;
        private long timeDuration;
}
