package com.stackroute.quizify.searchservice.service;


import com.stackroute.quizify.searchservice.domain.Game;
import com.stackroute.quizify.searchservice.exception.GenreAlreadyExistsException;
import com.stackroute.quizify.searchservice.domain.Genres;
import com.stackroute.quizify.searchservice.exception.GenreDoesNotExistsException;
import com.stackroute.quizify.searchservice.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * This "GenreServiceImpl" Class implements all the methods declared by "GenreService" Interface.
 *
 * Spring @Service annotation is used with classes that provide business functionalities/logics.
 */


@Service
public class GenreServiceImpl implements GenreService{
    GenreRepository genreRepository;

    @Autowired
    public GenreServiceImpl(GenreRepository genreRepository){
        this.genreRepository = genreRepository;
    }

    @Override
    public Genres saveGenre(Genres genres) throws GenreAlreadyExistsException {
        if (this.genreRepository.existsById(genres.getId()))
            throw new GenreAlreadyExistsException();
        else
        {
            if(this.genreRepository.findTopByOrderByIdDesc().isEmpty())
                genres.setId(1);
            else
                genres.setId(this.genreRepository.findTopByOrderByIdDesc().get().getId()+1);
            return genreRepository.save(genres);
        }
    }

    @Override
    public List<Genres> getAllGenreByStartsWith(String genreName) throws GenreDoesNotExistsException {
        List<Genres> genres = genreRepository.searchByGenreAlphabet(genreName);
        if(genres==null)
            throw new GenreDoesNotExistsException();
        else
            return genres;
    }


}
