package com.stackroute.quizify.searchservice.service;

import com.stackroute.quizify.searchservice.domain.Game;
import com.stackroute.quizify.searchservice.exception.GenreDoesNotExistsException;
import com.stackroute.quizify.searchservice.exception.NoGamesFoundException;
import com.stackroute.quizify.searchservice.exception.TopicDoesNotExistsException;

import java.util.List;

public interface UniversalService {
    List<Game> searchGame(String searchKey) throws NoGamesFoundException, GenreDoesNotExistsException, TopicDoesNotExistsException;
}
