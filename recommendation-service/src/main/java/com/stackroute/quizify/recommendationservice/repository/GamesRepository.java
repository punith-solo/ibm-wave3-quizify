package com.stackroute.quizify.recommendationservice.repository;

import com.stackroute.quizify.recommendationservice.domain.Games;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GamesRepository extends Neo4jRepository<Games,Long> {
    @Query("MATCH (Games) RETURN Games")
    public List<Games> getAllNodes();

    @Query("MATCH (g:Games) WHERE g.id={gameId} RETURN g")
    public Games getNode(@Param("gameId") long gameId);

    @Query("CREATE (g:Games) SET g.id={gameId},g.name={gameName} RETURN g")
    Games createNode( long gameId,String gameName);

    @Query("MATCH (g:Games) WHERE g.id={gameId} DETACH DELETE g RETURN 'node deleted' ")
    Games deleteNode(@Param("gameId") long gameId);

    @Query("MATCH (g:Games) WHERE g.id={gameId} SET g.name={gameName} RETURN g")
    Games updateNode(@Param("gameId") long gameId,@Param("gameName") String gameName);

}
