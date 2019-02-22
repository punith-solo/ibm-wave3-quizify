package com.stackroute.quizify.recommendationservice.repository;

import com.stackroute.quizify.recommendationservice.domain.Played;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlayedRelationshipRepository extends Neo4jRepository<Played,String> {

    @Query("MATCH p=(User)-[r:Played]->(Game) RETURN p")
    public List<Played> getAllRelationships();

    @Query("MATCH (p:User),(t:Game) WHERE id(p)={userId} and id(t)={gameId} CREATE (p)-[q:Played{score:{score}}]->(t) RETURN p,q,t")
    Played createRelationship(@Param("userId") long userId, @Param("gameId") long gameId, @Param("score") int score);

    @Query("MATCH (p:User)-[r:Played]->(t:Game) WHERE id(p)={userId} and id(t)={gameId} DELETE r RETURN 'relationship deleted' ")
    Played deleteRelationship(@Param("userId") Long userId, @Param("gameId") long gameId);

}
