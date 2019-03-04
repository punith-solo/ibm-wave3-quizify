package com.stackroute.quizify.userregistrationservice.component;

import com.stackroute.quizify.dto.model.UserDTO;
import com.stackroute.quizify.kafka.Producer;
import com.stackroute.quizify.userregistrationservice.exceptions.UserAlreadyExistException;
import com.stackroute.quizify.userregistrationservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class FeedDataApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    private UserService userService;
    private Producer producer;
    @Autowired
    public FeedDataApplicationListener(UserService userService, Producer producer) {
        this.userService = userService;
        this.producer = producer;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event)
    {
        UserDTO user = new UserDTO();
        user.setId(0);
        user.setName("kaustav");
        user.setEmailId("kaustavlogan@gmail.com");
        user.setPassword("1234567890");
        user.setTopics(null);
        user.setGenres(null);
        user.setGender("male");

        try
        {
            this.userService.saveUser(user);
            producer.send(user);
        }
        catch (UserAlreadyExistException e)
        {
            e.printStackTrace();
        }

    }
}
