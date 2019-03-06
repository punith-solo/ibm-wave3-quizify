package com.stackroute.quizify.singleplayerengine.service;

import com.stackroute.quizify.kafka.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PlayerServiceImpl implements PlayerService {

    private Producer producer;

    @Autowired
    public PlayerServiceImpl() {

    }

}

