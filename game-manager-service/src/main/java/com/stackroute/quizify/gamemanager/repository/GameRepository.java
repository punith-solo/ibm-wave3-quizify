package com.stackroute.quizify.gamemanager.repository;

import com.stackroute.quizify.gamemanager.domain.Game;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends MongoRepository<Game, String > {
    @Query("{ 'category._id': '?0' , 'topic._id': '?1' }")
    List<Game> getAllGames(String categoryName, String topicName);

    @Query("{ name: { $regex: '?0', $options: 'i'} }")
    List<Game> searchGames(String gameName);



}
