package com.stackroute.quizify.recommendationservice.repository;

import com.stackroute.quizify.kafka.domain.Topic;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicRepository extends Neo4jRepository<Topic,Long> {


    @Query("MATCH (Topic) RETURN Topic")
    public List<Topic> getAllNodes();
}
