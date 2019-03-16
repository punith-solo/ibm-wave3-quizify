package com.stackroute.quizify.recommendationservice.serviceImpl;

import com.stackroute.quizify.recommendationservice.domain.LikesGame;
import com.stackroute.quizify.recommendationservice.repository.LikesGameRelationshipRepository;
import com.stackroute.quizify.recommendationservice.service.LikesGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikesGameServiceImpl implements LikesGameService {

    private LikesGameRelationshipRepository likesGameRelationshipRepository;

    @Autowired
    public LikesGameServiceImpl(LikesGameRelationshipRepository likesGameRelationshipRepository) {
        this.likesGameRelationshipRepository = likesGameRelationshipRepository;
    }

    @Override
    public List<LikesGame> getAllRelationships() {
        return likesGameRelationshipRepository.getAllRelationships();
    }

    @Override
    public LikesGame createRelationship(String userName, long gameId) {

        return likesGameRelationshipRepository.createRelationship(userName,gameId);
    }

    @Override
    public LikesGame deleteRelationship(String userName, String gameName) {
        return likesGameRelationshipRepository.deleteRelationship(userName, gameName);
    }
}