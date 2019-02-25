package com.stackroute.quizify.searchservice.service;

import com.stackroute.quizify.searchservice.domain.Genre;
import com.stackroute.quizify.searchservice.exception.GenreAlreadyExistsException;
import com.stackroute.quizify.searchservice.exception.GenreDoesNotExistsException;

import java.util.List;

/*
 * This "GenreService" Interface is used to declare all the necessary services/methods
 * which are must be implemented by the Implementing Class (GenreServiceImpl).
 */

public interface GenreService {

    Genre saveGenre(Genre genre) throws GenreAlreadyExistsException;
//    List<Genre> getAllGenreByName(String topicName) throws GenreDoesNotExistsException;
    List<Genre> getAllGenreByStartsWith(String genreName)throws GenreDoesNotExistsException;
}
