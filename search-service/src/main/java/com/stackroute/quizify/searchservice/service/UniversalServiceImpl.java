package com.stackroute.quizify.searchservice.service;

import com.stackroute.quizify.searchservice.domain.Game;
import com.stackroute.quizify.searchservice.domain.Genre;
import com.stackroute.quizify.searchservice.domain.Topic;
import com.stackroute.quizify.searchservice.exception.GenreDoesNotExistsException;
import com.stackroute.quizify.searchservice.exception.NoGameFoundException;
import com.stackroute.quizify.searchservice.exception.TopicDoesNotExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UniversalServiceImpl implements UniversalService {
    private GenreServiceImpl genreService;
    private TopicServiceImpl topicService;

    @Autowired
    public UniversalServiceImpl(GenreServiceImpl genreService, TopicServiceImpl topicService)
    {
        this.genreService = genreService;
        this.topicService = topicService;
    }
    @Override
    public List<Game> searchGame(String searchKey) throws NoGameFoundException, GenreDoesNotExistsException, TopicDoesNotExistsException {
        List<Genre> genres= this.genreService.getAllGenreByStartsWith(searchKey);
        List<Topic> topics = this.topicService.getAllTopicByStartsWith(searchKey);
        List<Game> games = new ArrayList<>();
        for (Genre genre: genres)
        {
            games.addAll(genre.getGames());
        }
        for (Topic topic: topics)
        {
            games.addAll(topic.getGames());
        }

        if (games.isEmpty())
            throw new NoGameFoundException("No Game Found!");
        else
            return games;
    }

    @Override
    public Game deleteGame(long topicId, long genreId, long gameId) throws NoGameFoundException, TopicDoesNotExistsException, GenreDoesNotExistsException {
        this.topicService.deleteGameById(topicId, gameId);
        return this.genreService.deleteGameById(genreId, gameId);
    }
}
