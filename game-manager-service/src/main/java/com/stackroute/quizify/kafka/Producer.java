package com.stackroute.quizify.kafka;

import com.stackroute.quizify.gamemanager.domain.Game;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Producer {

    private String kafkaTopic;
    private KafkaTemplate<String, Game> kafkaTemplate;

    @Autowired
    public Producer(Environment env, KafkaTemplate<String, Game> kafkaTemplate)
    {
        this.kafkaTopic = env.getProperty("kafka.topic");
        this.kafkaTemplate = kafkaTemplate;
    }


    public Game send(Game payload) {
        kafkaTemplate.send(this.kafkaTopic, payload);
        log.info("---------------------------------------------------------------------------------------------------");
        log.info("Game Sent by Game-Manager-Service : ");
        log.info(""+payload);
        return payload;
    }
}
