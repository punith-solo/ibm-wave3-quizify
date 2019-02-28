package com.stackroute.quizify.kafka;

import com.stackroute.quizify.kafka.domain.Game;
import com.stackroute.quizify.kafka.domain.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer {

    private Environment env;
    private String kafkaTopic;
    private Logger logger = LoggerFactory.getLogger(Producer.class);
    private KafkaTemplate<String, Game> kafkaTemplate;

    @Autowired
    public Producer(Environment env, KafkaTemplate<String, Game> kafkaTemplate)
    {
        this.env = env;
        this.kafkaTopic = env.getProperty("kafka.topic");
        this.kafkaTemplate = kafkaTemplate;
    }


    public Game send(Game payload) {
        logger.info("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        logger.info("Game Sent by Game-Manager-Service : ");
        logger.info(""+payload);
        kafkaTemplate.send(this.kafkaTopic, payload);
        return payload;
    }
}
