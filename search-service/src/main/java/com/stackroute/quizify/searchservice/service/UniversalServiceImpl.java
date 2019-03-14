package com.stackroute.quizify.searchservice.service;

import com.stackroute.quizify.searchservice.domain.Game;
import com.stackroute.quizify.searchservice.domain.Genres;
import com.stackroute.quizify.searchservice.domain.Topics;
import com.stackroute.quizify.searchservice.exception.GenreDoesNotExistsException;
import com.stackroute.quizify.searchservice.exception.NoGamesFoundException;
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
    public List<Game> searchGame(String searchKey) throws NoGamesFoundException, GenreDoesNotExistsException, TopicDoesNotExistsException {
        List<Genres> genres= this.genreService.getAllGenreByStartsWith(searchKey);
        List<Topics> topics = this.topicService.getAllTopicByStartsWith(searchKey);
        List<Game> games = new ArrayList<>();
        for (Genres genre: genres)
        {
            games.addAll(genre.getGames());
        }
        for (Topics topic: topics)
        {
            for(Game game: topic.getGames())
            {
                if(!games.contains(game))
                {
                    games.add(game);
                }
            }
        }

        if (games.isEmpty())
            throw new NoGamesFoundException();
        else
            return games;
    }
}
