package com.stackroute.quizify.recommendationservice.repository;

import com.stackroute.quizify.kafka.domain.User;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends Neo4jRepository<User, Long> {
    
    @Query("MATCH (User) RETURN User")
    public List<User> getAllNodes();

    @Query("MATCH (u:User) WHERE id(u)={userId} RETURN u")
    public User getNode(@Param("userId") long userId);

    @Query("CREATE (u:User) SET u.id={userId},u.userName={userName},u.gender={gender} RETURN u")
    User createNode( long userId,String userName, String gender);

    @Query("MATCH (n:User) WHERE id(n)={userId} DETACH DELETE n RETURN 'node deleted' ")
    User deleteNode(@Param("userId") long userId);

    @Query("MATCH (n:User) WHERE id(n)={userId} SET n.userName={userName},n.gender={gender} RETURN n")
    User updateNode(@Param("userId") long userId,@Param("userName") String userName,@Param("gender") String gender);
}
