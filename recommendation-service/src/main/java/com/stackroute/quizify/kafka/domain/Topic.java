package com.stackroute.quizify.kafka.domain;

import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Property;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
public class Topic {
    @Id @GeneratedValue
    private long id;
    @Property
    private String topciName;
    @Property
    private String imageUrl;
}
