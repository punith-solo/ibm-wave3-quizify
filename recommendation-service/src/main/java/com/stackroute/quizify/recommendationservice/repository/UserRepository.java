package com.stackroute.quizify.recommendationservice.repository;

import com.stackroute.quizify.recommendationservice.domain.Game;
import com.stackroute.quizify.recommendationservice.domain.User;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends Neo4jRepository<User, Long> {
    
    @Query("MATCH (User) RETURN User")
    public List<User> getAllNodes();

    @Query("MATCH (u:User) WHERE u.id={userId} RETURN u")
    public User getNode(@Param("userId") long userId);

    @Query("CREATE (u:User) SET u.id={userId},u.name={userName},u.gender={gender} RETURN u")
    User createNode(long userId, String userName, String gender);
//    @Query("CREATE (u:User) SET u.id={userId},u.name={userName},u.gender={gender},u.playedGames={playedGames} RETURN u")
//    User createNode(long userId, String userName, String gender, List<Game> playedGames);

    @Query("MATCH (n:User) WHERE n.id={userId} DETACH DELETE n RETURN 'node deleted' ")
    User deleteNode(@Param("userId") long userId);

    @Query("MATCH (User) DETACH DELETE User")
    public List<User> deleteAllNodes();

    @Query("MATCH (n:User) WHERE n.id={userId} SET n.userName={userName},n.gender={gender} RETURN n")
    User updateNode(@Param("userId") long userId, @Param("userName") String userName, @Param("gender") String gender);
}
