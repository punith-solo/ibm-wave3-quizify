package com.stackroute.quizify.kafka;

import com.stackroute.quizify.signleplayerengine.domain.Game;
import com.stackroute.quizify.signleplayerengine.domain.GameUserHistory;
import com.stackroute.quizify.signleplayerengine.domain.SinglePlayer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer {

    @Value("${kafka.topic}")
    private String topic;

    private GameUserHistory payload;

    private Logger logger = LoggerFactory.getLogger(Producer.class);


    private KafkaTemplate<String, GameUserHistory> kafkaTemplate;

    public GameUserHistory getPayload()
    {
        return this.payload;
    }

    @Autowired
    public Producer(KafkaTemplate<String, GameUserHistory> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public GameUserHistory send(GameUserHistory payload) {
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Player game history Sent");
//        System.out.println(payload);
        kafkaTemplate.send(this.topic, payload);
        this.payload = payload;
        return payload;
    }
}
