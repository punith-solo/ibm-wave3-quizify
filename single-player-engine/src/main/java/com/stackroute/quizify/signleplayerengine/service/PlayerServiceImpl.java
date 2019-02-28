package com.stackroute.quizify.signleplayerengine.service;

import com.stackroute.quizify.kafka.Producer;
import com.stackroute.quizify.signleplayerengine.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PlayerServiceImpl implements PlayerService {

    private PlayerRepository playerRepository;
    private Producer producer;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository, Producer producer) {
        this.playerRepository = playerRepository;
        this.producer = producer;
    }

}

