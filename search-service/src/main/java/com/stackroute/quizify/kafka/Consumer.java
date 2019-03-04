package com.stackroute.quizify.kafka;

import com.stackroute.quizify.dto.mapper.GameMapper;
import com.stackroute.quizify.dto.model.GameDTO;
import com.stackroute.quizify.searchservice.domain.Game;
import com.stackroute.quizify.searchservice.domain.Genre;
import com.stackroute.quizify.searchservice.domain.Topic;
import com.stackroute.quizify.searchservice.repository.GenreRepository;
import com.stackroute.quizify.searchservice.repository.TopicRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class Consumer {

    private Game recievedGame;
    private GenreRepository genreRepository;
    private TopicRepository topicRepository;
    private GameMapper gameMapper;


    @Autowired
    public Consumer(GenreRepository genreRepository, TopicRepository topicRepository, GameMapper gameMapper) {
        this.genreRepository = genreRepository;
        this.topicRepository = topicRepository;
        this.gameMapper = gameMapper;
    }

    private Logger logger = LoggerFactory.getLogger(Consumer.class);

    @KafkaListener(topics = "games", groupId = "search-games-consumers", containerFactory = "kafkaListenerContainerFactory")
    public void receive(@Payload GameDTO payload) {
        recievedGame = this.gameMapper.gameDTOToGame(payload);
        logger.info("------------------------------------------------------------------------------------------------");
        logger.info("Game Received into Search : "+recievedGame);

        List<Game> newList;
        Topic topic;
        Genre genre;


        if (this.topicRepository.existsByName(payload.getTopic().getName()))
        {
            topic = this.topicRepository.findByName(payload.getTopic().getName());
            newList = topic.getGames();
            newList.add(recievedGame);
            topic.setGames(newList);
            this.topicRepository.save(topic);
        }
        else
        {
            topic = new Topic();
            newList = new ArrayList<>();
            if(this.topicRepository.findTopByOrderByIdDesc().isEmpty())
                topic.setId(1);
            else
                topic.setId(this.topicRepository.findTopByOrderByIdDesc().get().getId()+1);
            topic.setName(payload.getTopic().getName());
            topic.setImageUrl(payload.getImageUrl());
            newList.add(recievedGame);
            topic.setGames(newList);
            this.topicRepository.save(topic);
        }

        if (this.genreRepository.existsByName(payload.getGenre().getName()))
        {
            genre = this.genreRepository.findByName(payload.getGenre().getName());
            newList = genre.getGames();
            newList.add(recievedGame);
            genre.setGames(newList);
            this.genreRepository.save(genre);
        }
        else
        {
            genre = new Genre();
            newList = new ArrayList<>();
            if(this.genreRepository.findTopByOrderByIdDesc().isEmpty())
                genre.setId(1);
            else
                genre.setId(this.genreRepository.findTopByOrderByIdDesc().get().getId()+1);
            genre.setName(payload.getGenre().getName());
            genre.setImageUrl(payload.getImageUrl());
            newList.add(recievedGame);
            genre.setGames(newList);
            this.genreRepository.save(genre);
        }
    }
}
