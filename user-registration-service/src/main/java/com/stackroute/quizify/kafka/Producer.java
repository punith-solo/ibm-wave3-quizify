package com.stackroute.quizify.kafka;

import com.stackroute.quizify.userregistrationservice.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Producer {
    private String topic;

    private KafkaTemplate<String, User> kafkaTemplate;

    @Autowired
    public Producer(Environment env, KafkaTemplate<String, User> kafkaTemplate) {
        this.topic = env.getProperty("kafka.topic");
        this.kafkaTemplate = kafkaTemplate;
    }

    public User send(User payload) {
        kafkaTemplate.send(this.topic, payload);
        log.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        log.info("User Sent from User Registration Service : ");
        log.info(""+payload);
        return payload;
    }
}
