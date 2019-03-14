package com.stackroute.quizify.kafka;

import com.stackroute.quizify.dto.mapper.GameMapper;
import com.stackroute.quizify.dto.mapper.UserMapper;
import com.stackroute.quizify.dto.model.SinglePlayerDTO;
import com.stackroute.quizify.dto.model.UserDTO;
import com.stackroute.quizify.userregistrationservice.domain.Game;
import com.stackroute.quizify.userregistrationservice.domain.User;
import com.stackroute.quizify.userregistrationservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class Consumer {

    private GameMapper gameMapper;
    private Game game;
    private User user;
    private List<Game> played;

    private UserRepository userRepository;

    @Autowired
    public Consumer(GameMapper gameMapper, UserRepository userRepository)
    {
        this.gameMapper = gameMapper;
        this.userRepository = userRepository;
    }

    @KafkaListener(topics = "single-player", groupId = "reg-single-player-consumer", containerFactory = "kafkaListenerContainerFactory")
    public void receive(@Payload SinglePlayerDTO payload) {
        log.info("---------------------------------------------------------------------------------------------------");
        log.info("User Game History Received At User Registration Service : "+payload);
        this.user = this.userRepository.findByName(payload.getPlayerName());
        this.game = this.gameMapper.gameDTOToGame(payload.getGame());
        this.played = this.user.getGamesPlayed();
        this.played.add(this.game);
        this.user.setGamesPlayed(this.played);
        this.userRepository.save(this.user);
    }

}
