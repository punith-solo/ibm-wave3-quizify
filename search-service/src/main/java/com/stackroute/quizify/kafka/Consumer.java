package com.stackroute.quizify.kafka;

import com.stackroute.quizify.kafka.domain.Game;

import com.stackroute.quizify.kafka.domain.Tag;
import com.stackroute.quizify.searchservice.domain.Games;
import com.stackroute.quizify.searchservice.domain.Genres;
import com.stackroute.quizify.searchservice.domain.Topics;
import com.stackroute.quizify.searchservice.repository.GenreRepository;
import com.stackroute.quizify.searchservice.repository.TopicRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class Consumer {

    private Games recievedGame;
    private GenreRepository genreRepository;
    private TopicRepository topicRepository;

    public Consumer(GenreRepository genreRepository, TopicRepository topicRepository) {
        this.genreRepository = genreRepository;
        this.topicRepository = topicRepository;
    }

    private Logger logger = LoggerFactory.getLogger(Consumer.class);
    //private Game recievedPayload;



    //public Game getRecievedPayload()
   // {
     //   return this.recievedPayload;
    //}

    @KafkaListener(topics = "games", groupId = "search-games-consumers", containerFactory = "kafkaListenerContainerFactory")
    public void receive(@Payload Game payload) {
        logger.info("------------------------------------------------------------------------------------------------");
        logger.info("Game Received To Search : "+payload);


      //  this.recievedPayload = payload;

        recievedGame = new Games();
        recievedGame.setId(payload.getId());
        recievedGame.setName(payload.getName());
        recievedGame.setLevel(payload.getLevel());
        recievedGame.setImageUrl(payload.getImageUrl());
        recievedGame.setNumOfQuestion(payload.getNumOfQuestion());
        recievedGame.setDuration(payload.getTimeDuration());
        recievedGame.setDescription(payload.getRules());
        recievedGame.setGamesPlayed(payload.getPlayCount());
        recievedGame.setLikes(payload.getLiked());

        List<Games> newList = null;
        Topics topics =null;
        Genres genres = null;
        Tag tag = null;

        if (this.topicRepository.existsByName(payload.getTopic().getName()))
        {
            topics = this.topicRepository.findByName(payload.getTopic().getName());
            newList = topics.getGame();
            newList.add(recievedGame);
            topics.setGame(newList);
            this.topicRepository.save(topics);
        }
        else
        {
            topics = new Topics();
            newList = new ArrayList<>();
            if(this.topicRepository.findTopByOrderByIdDesc().isEmpty())
                topics.setId(1);
            else
                topics.setId(this.topicRepository.findTopByOrderByIdDesc().get().getId()+1);
            topics.setName(payload.getTopic().getName());
            topics.setImageUrl(payload.getImageUrl());
            newList.add(recievedGame);
            topics.setGame(newList);
            this.topicRepository.save(topics);
        }

        if (this.genreRepository.existsByName(payload.getGenre().getName()))
        {
            genres = this.genreRepository.findByName(payload.getGenre().getName());
            newList = genres.getGame();
            newList.add(recievedGame);
            genres.setGame(newList);
            this.genreRepository.save(genres);
        }
        else
        {
            genres = new Genres();
            newList = new ArrayList<>();
            if(this.genreRepository.findTopByOrderByIdDesc().isEmpty())
                genres.setId(1);
            else
                genres.setId(this.genreRepository.findTopByOrderByIdDesc().get().getId()+1);
            genres.setName(payload.getGenre().getName());
            genres.setImageUrl(payload.getImageUrl());
            newList.add(recievedGame);
            genres.setGame(newList);
            this.genreRepository.save(genres);
        }


    }

}
