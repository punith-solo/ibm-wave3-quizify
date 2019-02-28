package com.stackroute.quizify.kafka;

import com.stackroute.quizify.kafka.domain.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer {

    private Environment env;
    private String kafkaTopic;
    private Logger logger = LoggerFactory.getLogger(Producer.class);
    private KafkaTemplate<String, Question> kafkaTemplate;

    @Autowired
    public Producer(Environment env, KafkaTemplate<String, Question> kafkaTemplate)
    {
        this.env = env;
        this.kafkaTopic = env.getProperty("kafka.topic");
        this.kafkaTemplate = kafkaTemplate;
    }

    public Question send(Question payload) {
        logger.info("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        logger.info("Sending Questions from Question-manager-Service : ");
        logger.info(""+payload);
        kafkaTemplate.send(this.kafkaTopic, payload);
        return payload;
    }
}
