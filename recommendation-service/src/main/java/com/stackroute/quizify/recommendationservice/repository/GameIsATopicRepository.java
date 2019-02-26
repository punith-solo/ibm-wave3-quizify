package com.stackroute.quizify.recommendationservice.repository;

import com.stackroute.quizify.recommendationservice.domain.GameIsATopic;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameIsATopicRepository extends Neo4jRepository<GameIsATopic,Long> {
    @Query("MATCH p=(Game)-[r:is_a]->(Topic) RETURN p")
    public List<GameIsATopic> getAllRelationships();

    @Query("MATCH (p:Game),(t:Topic) WHERE id(p)={gameId} and id(t)={topicId} CREATE (p)-[q:is_a}]->(t) RETURN p,q,t")
    GameIsATopic createRelationship(@Param("gameId") long gameId, @Param("topicId") long topicId);
}
