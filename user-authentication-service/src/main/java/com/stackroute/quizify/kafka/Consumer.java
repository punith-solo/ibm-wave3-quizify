package com.stackroute.quizify.kafka;

import com.stackroute.quizify.dto.mapper.UserMapper;
import com.stackroute.quizify.dto.model.UserDTO;
import com.stackroute.quizify.userauthentication.domain.User;
import com.stackroute.quizify.userauthentication.exceptions.UserAlreadyExists;
import com.stackroute.quizify.userauthentication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;


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


    @KafkaListener(topics = "users", groupId = "login-users-consumers", containerFactory = "kafkaListenerContainerFactory")
    public void receive(@Payload UserDTO payload) throws UserAlreadyExists {
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("User data Received : ");
        System.out.println(payload);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        this.user = this.userMapper.userDTOToUser(payload);
        user.setId(0);
        user.setRole("player");

        this.userService.saveUser(user);


    }

}
