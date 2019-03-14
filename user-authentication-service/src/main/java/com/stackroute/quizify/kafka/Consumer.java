package com.stackroute.quizify.kafka;

import com.stackroute.quizify.dto.mapper.UserMapper;
import com.stackroute.quizify.dto.model.UserDTO;
import com.stackroute.quizify.userauthentication.domain.User;
import com.stackroute.quizify.userauthentication.exceptions.UserAlreadyExistsException;
import com.stackroute.quizify.userauthentication.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Consumer {

    private UserService userService;
    private UserMapper userMapper;
    private User user;

    @Autowired
    public Consumer(UserService userService, UserMapper userMapper)
    {
        this.userService = userService;
        this.userMapper = userMapper;
    }


    @KafkaListener(topics = "users", groupId = "login-user-consumers", containerFactory = "kafkaListenerContainerFactory")
    public void receive(@Payload UserDTO payload) {
        log.info("---------------------------------------------------------------------------------------------------");
        log.info("Payload Received at User-Authentication : ");
        log.info(""+payload);

        this.user = this.userMapper.userDTOToUser(payload);
        user.setId(0);
        user.setRole("player");

        try
        {
            this.userService.saveUser(user);
        }
        catch (UserAlreadyExistsException e)
        {
            e.printStackTrace();
        }


    }

}
