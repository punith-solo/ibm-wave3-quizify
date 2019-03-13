package com.stackroute.quizify.kafka;
import com.stackroute.quizify.singleplayerengine.domain.SinglePlayer;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Producer {
    private String topic;

    private KafkaTemplate<String, SinglePlayer> kafkaTemplate;

    @Autowired
    public Producer(Environment env, KafkaTemplate<String, SinglePlayer> kafkaTemplate) {
        this.topic = env.getProperty("kafka.topic");
        this.kafkaTemplate = kafkaTemplate;
    }

    public SinglePlayer send(SinglePlayer payload) {
        log.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        log.info("Player game history Sent : ");
        log.info(""+payload);
        kafkaTemplate.send(this.topic, payload);
        return payload;
    }
}
