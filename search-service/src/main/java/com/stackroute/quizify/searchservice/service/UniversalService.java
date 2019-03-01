package com.stackroute.quizify.searchservice.service;

import com.stackroute.quizify.searchservice.domain.Games;
import com.stackroute.quizify.searchservice.exception.GenreDoesNotExistsException;
import com.stackroute.quizify.searchservice.exception.NoGameFoundException;
import com.stackroute.quizify.searchservice.exception.TopicDoesNotExistsException;

import java.util.List;

public interface UniversalService {
    List<Games> searchGame(String searchKey) throws NoGameFoundException, GenreDoesNotExistsException, TopicDoesNotExistsException;
}
