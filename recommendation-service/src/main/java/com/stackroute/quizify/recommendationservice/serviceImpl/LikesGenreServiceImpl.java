package com.stackroute.quizify.recommendationservice.serviceImpl;


import com.stackroute.quizify.recommendationservice.domain.Genre;
import com.stackroute.quizify.recommendationservice.domain.LikesGenre;
import com.stackroute.quizify.recommendationservice.domain.User;
import com.stackroute.quizify.recommendationservice.repository.LikesGenreRelationshipRepository;
import com.stackroute.quizify.recommendationservice.service.LikesGenreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ListIterator;

@Slf4j
@Service
public class LikesGenreServiceImpl implements LikesGenreService {

    private LikesGenreRelationshipRepository likesGenreRelationshipRepository;

    @Autowired
    public LikesGenreServiceImpl(LikesGenreRelationshipRepository likesGenreRelationshipRepository) {
        this.likesGenreRelationshipRepository = likesGenreRelationshipRepository;
    }


    @Override
    public List<LikesGenre> getAllRelationships() {
        return likesGenreRelationshipRepository.getAllRelationships();
    }

    @Override
    public String createRelationship(User user) {
        long userId = user.getId();
        List<Genre> genres = user.getGenres();
        ListIterator<Genre> genresIterator = genres.listIterator();
        while(genresIterator.hasNext()){
            Genre genre=genresIterator.next();
            log.info(genre.toString());
            String genreName=genre.getName();
            log.info("userId: "+userId+"genreId: "+genreName);
            likesGenreRelationshipRepository.createRelationship(userId,genreName);
        }
        return " "; //change as required
    }
}
