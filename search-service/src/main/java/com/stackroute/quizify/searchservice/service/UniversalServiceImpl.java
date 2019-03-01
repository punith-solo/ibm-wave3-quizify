package com.stackroute.quizify.searchservice.service;

import com.stackroute.quizify.searchservice.domain.Games;
import com.stackroute.quizify.searchservice.domain.Genres;
import com.stackroute.quizify.searchservice.domain.Topics;
import com.stackroute.quizify.searchservice.exception.GenreDoesNotExistsException;
import com.stackroute.quizify.searchservice.exception.NoGameFoundException;
import com.stackroute.quizify.searchservice.exception.TopicDoesNotExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.PrimitiveIterator;

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
    public List<Games> searchGame(String searchKey) throws NoGameFoundException, GenreDoesNotExistsException, TopicDoesNotExistsException {
        List<Genres> genres= this.genreService.getAllGenreByStartsWith(searchKey);
        List<Topics> topics = this.topicService.getAllTopicByStartsWith(searchKey);
        List<Games> games = new ArrayList<>();
        for (Genres genre: genres)
        {
            games.addAll(genre.getGame());
        }
        for (Topics topic: topics)
        {
            games.addAll(topic.getGame());
        }

        if (games.isEmpty())
            throw new NoGameFoundException("No Game Found!");
        else
            return games;
    }
}
