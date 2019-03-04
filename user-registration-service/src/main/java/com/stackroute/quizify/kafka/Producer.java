package com.stackroute.quizify.kafka;

import com.stackroute.quizify.dto.mapper.UserMapper;
import com.stackroute.quizify.dto.model.UserDTO;
import com.stackroute.quizify.userregistrationservice.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer {

    @Value("${kafka.topic}")
    private  String topic;

    private User payload;

    private Logger logger = LoggerFactory.getLogger(Producer.class);


    private KafkaTemplate<String, UserDTO> kafkaTemplate;
    private UserMapper userMapper;
    private UserDTO userDTO;

    @Autowired
    public Producer(KafkaTemplate<String, UserDTO> kafkaTemplate, UserMapper userMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.userMapper = userMapper;
    }

    public UserDTO send(UserDTO payload) {
        kafkaTemplate.send(this.topic, payload);
        logger.info("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        logger.info("User Sent from User Registration Service : "+payload);
        return this.userDTO;
    }
}
