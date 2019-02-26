package com.stackroute.quizify.kafka.domain;

import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

import java.util.List;

@NodeEntity
@Data
public class Topic {
    @Id @GeneratedValue
    private long id;
    @Property
    private String topciName;
    @Property
    private String imageUrl;
}
