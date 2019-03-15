package com.stackroute.quizify.recommendationservice.repository;

import com.stackroute.quizify.recommendationservice.domain.*;
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

    @Query("CREATE (g:Game) SET g.id={gameId},g.name={gameName},g.playCount={playCount},g.level={level},g.imageUrl={imageUrl},g.numOfQuestion={numOfQuestion},g.timeDuration={timeDuration},g.liked={liked},g.rules={rules},g.pointPerQuestion={pointPerQuestion},g.totalPoints={totalPoints},g.playerScore={playerScore} RETURN g")
    Game createNode(long gameId, String gameName, int playCount, String level, String imageUrl, int numOfQuestion, int timeDuration, int liked, List<String> rules, int pointPerQuestion, int totalPoints, int playerScore); //, Category category, Topic topic, Genre genre

    @Query("MATCH (g:Game) WHERE g.id={gameId} DETACH DELETE g RETURN 'node deleted' ")
    Game deleteNode(@Param("gameId") long gameId);

    @Query("MATCH (g:Game) WHERE g.id={gameId} SET g.name={gameName} RETURN g")
    Game updateNode(@Param("gameId") long gameId, @Param("gameName") String gameName);

    @Query("MATCH (u:User)-[r:Played]->(g:Game) RETURN g, COUNT(distinct g.playcount) AS cnt ORDER BY cnt DESC LIMIT 9")
    List<Game> getMostPlayed();

    @Query("MATCH (ga:Game),(ge:Genre) WHERE ge.id={genreId} and (ga:Game)-[:game_type_of]->(ge:Genre) RETURN ga")
    public List<Game> getAllRelatedGamesOfAGenre(@Param("genreId") long genreId);

    @Query("MATCH (ga:Game),(ge:Genre) WHERE ge.id={genreName} and (ga:Game)-[:game_type_of]->(ge:Genre) RETURN ga")
    public List<Game> getAllRelatedGamesOfAGenreByName(@Param("genreName") String genreName);

    @Query("MATCH (ga:Game),(t:Topic) WHERE t.id={topicId} and (ga:Game)-[:game_is_a]->(t:Topic) RETURN ga")
    public List<Game> getAllRelatedGamesOfATopic(@Param("topicId") long topicId);

    @Query("MATCH (ga:Game),(t:Topic) WHERE t.name={topicName} and (ga:Game)-[:game_is_a]->(t:Topic) RETURN ga")
    public List<Game> getAllRelatedGamesOfATopicByName(@Param("topicName") String topicName);

    @Query("MATCH (ga:Game),(u:User) WHERE u.id={userId} and (u:User)-[:Played]->(g:game) RETURN g")
    public List<Game> getAllGamesPlayedByAUser(@Param("userId") long userId);

    @Query("MATCH (ga:Game),(u:User) WHERE u.name={userName} and (u:User)-[:Played]->(g:game) RETURN g")
    public List<Game> getAllGamesPlayedByAUserName(@Param("userName") String userName);

    @Query("MATCH (ga:Game),(u:User) WHERE u.id={userId} and (u:User)-[:LikesGame]->(g:game) RETURN g")
    List<Game> getAllGamesLikedByAUser(@Param("userId") long userId);

    @Query("MATCH (ga:Game),(u:User) WHERE u.name={userName} and (u:User)-[:LikesGame]->(g:game) RETURN g")
    List<Game> getAllGamesLikedByAUserName(@Param("userName") String userName);

    @Query("MATCH (g:Game) where g.level={level} return g")
    List<Game> getAllGamesByLevel(String level);
}
