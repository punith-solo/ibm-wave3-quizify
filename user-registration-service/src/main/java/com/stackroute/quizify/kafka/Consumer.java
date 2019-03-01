package com.stackroute.quizify.kafka;

import com.stackroute.quizify.kafka.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;



@Component
public class Consumer {


    //private Game recievedPayload;
    private Logger logger = LoggerFactory.getLogger(Producer.class);



    //public Game getRecievedPayload()
   // {
     //   return this.recievedPayload;
    //}

    @KafkaListener(topics = "users", groupId = "users-self-consumers", containerFactory = "kafkaListenerContainerFactory")
    public void receive(@Payload User payload) {
        logger.info("------------------------------------------------------------------------------------------------");
        logger.info("User Received At User Registration Service : "+payload);

      //  this.recievedPayload = payload;


    }

}
