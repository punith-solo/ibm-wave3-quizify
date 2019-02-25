package com.stackroute.quizify.recommendationservice.repository;

import com.stackroute.quizify.kafka.domain.Game;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GameRepository extends Neo4jRepository<Game,Long> {
    @Query("MATCH (Game) RETURN Game")
    public List<Game> getAllNodes();

    @Query("MATCH (g:Game) WHERE id(g)={id} RETURN g")
    public Game getNode(@Param("id") long id);

    @Query("CREATE (g:Game) SET g.id={id},g.name={name} RETURN g")
    Game createNode( long id,String name);

    @Query("MATCH (g:Game) WHERE id(g)={id} DETACH DELETE g RETURN 'node deleted' ")
    Game deleteNode(@Param("id") long id);

    @Query("MATCH (g:Game) WHERE id(g)={id} SET g.name={name} RETURN g")
    Game updateNode(@Param("id") long id,@Param("name") String name);

}
