package com.stackroute.quizify.kafka.domain;

import com.stackroute.quizify.recommendationservice.domain.Admin;
import com.stackroute.quizify.recommendationservice.domain.Category;
import com.stackroute.quizify.recommendationservice.domain.Question;
import com.stackroute.quizify.recommendationservice.domain.Topic;
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
        public long gameId;
        @Property
        private String name;
        private Category category;
        private Topic topic;
        private int playCount;
        private int numOfQuestion;
        private List<Question> questions;
        private Admin admin;
        private String level;
        private String genre;
        private String tag;
        private int liked;
        private int played;
        private int timestamp;
}
