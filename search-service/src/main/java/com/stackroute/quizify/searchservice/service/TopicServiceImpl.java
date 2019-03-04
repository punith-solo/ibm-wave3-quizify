package com.stackroute.quizify.searchservice.service;

import com.stackroute.quizify.searchservice.domain.Game;
import com.stackroute.quizify.searchservice.domain.Genre;
import com.stackroute.quizify.searchservice.domain.Topic;
import com.stackroute.quizify.searchservice.exception.GenreDoesNotExistsException;
import com.stackroute.quizify.searchservice.exception.NoGameFoundException;
import com.stackroute.quizify.searchservice.exception.TopicDoesNotExistsException;
import com.stackroute.quizify.searchservice.exception.TopicAlreadyExistsException;
import com.stackroute.quizify.searchservice.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * This "TopicServiceImpl" Class implements all the methods declared by "TopicService" Interface.
 *
 * Spring @Service annotation is used with classes that provide business functionalities/logics.
 */

@Service
public class TopicServiceImpl implements TopicService{

    private TopicRepository topicRepository;

    @Autowired
    public TopicServiceImpl(TopicRepository topicRepository){
        this.topicRepository=topicRepository;
    }

//    @Override
//    public List<Topic> getAllTopicByName(String topicName) throws TopicDoesNotExistsException {
//        List<Topic> allTopics = topicRepository.searchByTopicName(topicName);
//        if(allTopics==null)
//            throw new TopicDoesNotExistsException("No Game Found");
//        else
//            return allTopics;
//    }

    @Override
    public Topic saveTopic(Topic topic) throws TopicAlreadyExistsException {
        if (this.topicRepository.existsById(topic.getId()))
            throw new TopicAlreadyExistsException("Genre Already Exists!");
        else
        {
            if(this.topicRepository.findTopByOrderByIdDesc().isEmpty())
                topic.setId(1);
            else
                topic.setId(this.topicRepository.findTopByOrderByIdDesc().get().getId()+1);
            return topicRepository.save(topic);
        }
    }

    @Override
    public List<Topic> getAllTopicByStartsWith(String topicName) throws TopicDoesNotExistsException {
        List<Topic> topics = topicRepository.searchByTopicAlphabet(topicName);
        if(topics==null)
            throw new TopicDoesNotExistsException("No Game Found");
        else
            return topics;
    }

    @Override
    public Game deleteGameById(long topicId, long gameId) throws TopicDoesNotExistsException, NoGameFoundException {
        if (this.topicRepository.existsById(topicId))
        {
            Topic topic = this.topicRepository.findById(topicId).get();
            List<Game> games = topic.getGames();
            if (games.isEmpty())
                throw new NoGameFoundException("No Game Found!");
            for (Game game: games)
            {
                if (game.getId() == gameId)
                {
                    Game deletedGame = game;
                    games.remove(deletedGame);
                    topic.setGames(games);
                    return deletedGame;
                }
            }
            throw new NoGameFoundException("Game Not Found!");

        }
        else
            throw new TopicDoesNotExistsException("Genre Doesn't Exist!");
    }
}
