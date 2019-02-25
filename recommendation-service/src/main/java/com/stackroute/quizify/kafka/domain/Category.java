package com.stackroute.quizify.kafka.domain;

import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Property;
import org.springframework.data.annotation.Id;

@Data
public class Category{
    @Id @GeneratedValue
    private long id;
    @Property
    private String categoryName;
    @Property
    private String imageUrl;
}