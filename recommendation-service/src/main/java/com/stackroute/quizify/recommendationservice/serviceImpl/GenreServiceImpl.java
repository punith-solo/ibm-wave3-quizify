package com.stackroute.quizify.recommendationservice.serviceImpl;

import com.stackroute.quizify.recommendationservice.domain.Genre;
import com.stackroute.quizify.recommendationservice.repository.GenreRepository;
import com.stackroute.quizify.recommendationservice.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {

    GenreRepository genreRepository;

    @Autowired
    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }


    @Override
    public List<Genre> getAll() {
        return genreRepository.getAllNodes();
    }

    @Override
    public List<Genre> getGenresByCategory(long categoryId) {
        return genreRepository.getGenresBycategory(categoryId);
    }

    @Override
    public List<Genre> getGenresByCategoryName(String categoryName) {
        return genreRepository.getGenresByCategoryName(categoryName);
    }
}
