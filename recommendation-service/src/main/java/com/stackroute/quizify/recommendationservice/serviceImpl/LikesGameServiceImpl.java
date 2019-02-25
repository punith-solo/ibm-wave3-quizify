package com.stackroute.quizify.recommendationservice.serviceImpl;

import com.stackroute.quizify.recommendationservice.domain.LikesGame;
import com.stackroute.quizify.recommendationservice.service.LikesGameService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LikesGameServiceImpl implements LikesGameService {

    private LikesGameService likesGameService;

    @Autowired
    public LikesGameServiceImpl(LikesGameService likesGameService) {
        this.likesGameService = likesGameService;
    }

    @Override
    public List<LikesGame> getAllRelationships() {
        return likesGameService.getAllRelationships();
    }

    @Override
    public LikesGame createRelationship(long userId, long gameId) {
        return likesGameService.createRelationship(userId,gameId);
    }

    @Override
    public LikesGame deleteRelationship(long userId, long gameId) {
        return likesGameService.deleteRelationship(userId, gameId);
    }
}