package com.stackroute.quizify.gamemanager.repository;


import com.stackroute.quizify.gamemanager.domain.Game;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GameRepository extends MongoRepository<Game, Long> {

    Optional<Game> findTopByOrderByIdDesc();

    Game findById(long id);

    boolean existsById(long id);

    @Query("{ 'topic.name': '?0' }")
    List<Game> findGamesByTopic(String topicName);

    @Query("{ 'genre.name': '?0' }")
    List<Game> findGamesByGenre(String genreName);
}
