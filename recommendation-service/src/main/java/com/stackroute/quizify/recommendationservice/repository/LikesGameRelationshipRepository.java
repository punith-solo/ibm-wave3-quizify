package com.stackroute.quizify.recommendationservice.repository;

import com.stackroute.quizify.recommendationservice.domain.LikesGame;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikesGameRelationshipRepository extends Neo4jRepository<LikesGame, Long> {
    @Query("MATCH p=(User)-[r:LikesGame]->(Game) RETURN p")
    public List<LikesGame> getAllRelationships();

    @Query("MATCH (p:User),(t:Game) WHERE p.name={userName} and t.id={gameName} CREATE (p)-[q:LikesGame]->(t) RETURN p,q,t")
    LikesGame createRelationship(@Param("userName") String userName, @Param("gameName") long gameName);

    @Query("MATCH (p:User)-[r:LikesGame]->(t:Game) WHERE p.name={userName} and t.name={gameName} DELETE r RETURN 'relationship deleted' ")
    LikesGame deleteRelationship(@Param("userName") String userName, @Param("gameName") String gameName);
}
