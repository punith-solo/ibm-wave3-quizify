package com.stackroute.quizify.kafka;

import com.stackroute.quizify.kafka.domain.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;


@Component
public class Consumer {
    private Logger logger = LoggerFactory.getLogger(Consumer.class);

    private Environment env;
    private String kafkaTopic;
    private String consumerId;
    private String bootstrapServer;


    @Autowired
    public Consumer(Environment env)
    {
        this.env = env;
        this.kafkaTopic = env.getProperty("kafka.topic");
        this.consumerId = env.getProperty("kafka.group-id");
        this.bootstrapServer = env.getProperty("kafka.bootstrap-server");

    }


    @KafkaListener(topics = "questions", groupId = "questions-self-consumers", containerFactory = "kafkaListenerContainerFactory")
    public void receive(@Payload Question payload) {
        logger.info("------------------------------------------------------------------------------------------------");
        logger.info("Question Received by Question-Manager-Service : ");
        logger.info(""+payload);

    }

}
