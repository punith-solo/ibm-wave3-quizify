package com.stackroute.quizify.signleplayerengine.service;

import com.stackroute.quizify.kafka.Producer;
import com.stackroute.quizify.signleplayerengine.domain.Game;
import com.stackroute.quizify.signleplayerengine.domain.GameUserHistory;
import com.stackroute.quizify.signleplayerengine.domain.SinglePlayer;
import com.stackroute.quizify.signleplayerengine.domain.User;
import com.stackroute.quizify.signleplayerengine.exception.GamePlayerAlreadyExistsException;
import com.stackroute.quizify.signleplayerengine.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PlayerServiceImpl implements PlayerService {

    private PlayerRepository playerRepository;
    private Producer producer;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository, Producer producer) {
        this.playerRepository = playerRepository;
        this.producer = producer;
    }
    @Override
    public SinglePlayer saveGameHistory(SinglePlayer singlePlayer) throws GamePlayerAlreadyExistsException {
        if (this.playerRepository.existsById(singlePlayer.getId()))
            throw new GamePlayerAlreadyExistsException("ID Already Exists!");
        else {
            if (this.playerRepository.findTopByOrderByIdDesc().isEmpty())
                singlePlayer.setId(1);
            else
                singlePlayer.setId(this.playerRepository.findTopByOrderByIdDesc().get().getId() + 1);
            return this.playerRepository.save(singlePlayer);
        }

    }
}