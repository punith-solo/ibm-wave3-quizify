package com.stackroute.quizify.recommendationservice.repository;

import com.stackroute.quizify.recommendationservice.domain.Game;
import com.stackroute.quizify.recommendationservice.domain.GameTypeOfGenre;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GamesRepository extends Neo4jRepository<Game,Long> {
    @Query("MATCH (Game) RETURN Game")
    public List<Game> getAllNodes();

    @Query("MATCH (g:Game) WHERE g.id={gameId} RETURN g")
    public Game getNode(@Param("gameId") long gameId);

    @Query("CREATE (g:Game) SET g.id={gameId},g.name={gameName},g.playCount={playCount},g.level={level},g.imageUrl={imageUrl},g.numOfQuestion={numOfQuestion},g.timeDuration={timeDuration},g.liked={liked},g.rules={rules} RETURN g")
    Game createNode(long gameId, String gameName, int playCount, String level, String imageUrl, int numOfQuestion, int timeDuration, int liked, List<String> rules);

    @Query("MATCH (g:Game) WHERE g.id={gameId} DETACH DELETE g RETURN 'node deleted' ")
    Game deleteNode(@Param("gameId") long gameId);

    @Query("MATCH (g:Game) WHERE g.id={gameId} SET g.name={gameName} RETURN g")
    Game updateNode(@Param("gameId") long gameId, @Param("gameName") String gameName);

    @Query("MATCH (u:User)-[r:Played]->(g:Game) RETURN g, COUNT(distinct g.playcount) AS cnt ORDER BY cnt DESC LIMIT 9")
    List<Game> getMostPlayed();

    @Query("MATCH (ga:Game),(ge:Genre) WHERE ge.id={genreId} and (ga:Game)-[:game_type_of]->(ge:Genre) RETURN ga")
    public List<Game> getAllRelatedGamesOfAGenre(@Param("genreId") long genreId);

    @Query("MATCH (ga:Game),(t:Topic) WHERE t.id={topicId} and (ga:Game)-[:game_is_a]->(t:Topic) RETURN ga")
    public List<Game> getAllRelatedGamesOfATopic(@Param("topicId") long topicId);

    @Query("MATCH (ga:Game),(u:User) WHERE u.id={userId} and (u:User)-[:Played]->(g:game) RETURN g")
    public List<Game> getAllGamesPlayedByAUser(@Param("userId") long userId);

    @Query("MATCH (ga:Game),(u:User) WHERE u.id={userId} and (u:User)-[:LikesGame]->(g:game) RETURN g")
    List<Game> getAllGamesLikedByAUser(@Param("userId") long userId);
}
