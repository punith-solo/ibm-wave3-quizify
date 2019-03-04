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

    @Query("CREATE (g:Games) SET g.id={gameId},g.name={gameName},g.playCount={playCount},g.level={level},g.imageUrl={imageUrl},g.numOfQuestion={numOfQuestion},g.timeDuration={timeDuration},g.liked={liked},g.rules={rules} RETURN g")
    Games createNode( long gameId,String gameName,int playCount, String level, String imageUrl,int numOfQuestion,int timeDuration,int liked, List<String> rules);

    @Query("MATCH (g:Games) WHERE g.id={gameId} DETACH DELETE g RETURN 'node deleted' ")
    Games deleteNode(@Param("gameId") long gameId);

    @Query("MATCH (g:Games) WHERE g.id={gameId} SET g.name={gameName} RETURN g")
    Games updateNode(@Param("gameId") long gameId,@Param("gameName") String gameName);

    @Query("MATCH (u:Users)-[r:Played]->(g:Games) RETURN g, COUNT(distinct g.playcount) AS cnt ORDER BY cnt DESC LIMIT 9")
    List<Games> getMostPlayed();
}
