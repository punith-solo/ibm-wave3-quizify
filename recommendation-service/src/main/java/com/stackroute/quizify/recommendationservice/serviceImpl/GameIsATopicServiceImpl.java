package com.stackroute.quizify.recommendationservice.serviceImpl;

import com.stackroute.quizify.kafka.domain.Game;
import com.stackroute.quizify.kafka.domain.Topic;
import com.stackroute.quizify.recommendationservice.domain.GameIsATopic;
import com.stackroute.quizify.recommendationservice.repository.GameIsATopicRepository;
import com.stackroute.quizify.recommendationservice.service.GameIsATopicService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GameIsATopicServiceImpl implements GameIsATopicService {

    private GameIsATopicRepository gameIsATopicRepository;

    @Autowired
    public GameIsATopicServiceImpl(GameIsATopicRepository gameIsATopicRepository) {
        this.gameIsATopicRepository = gameIsATopicRepository;
    }

    @Override
    public List<GameIsATopic> getAllRelationships() {
        return gameIsATopicRepository.getAllRelationships();
    }

    @Override
    public GameIsATopic createRelationship(Game game) {
        long gameId=game.getId();
        Topic topic=game.getTopic();
        long topicId=topic.getId();
        return gameIsATopicRepository.createRelationship(gameId,topicId);
    }
}
