package com.stackroute.quizify.userregistrationservice.component;

import com.stackroute.quizify.kafka.Producer;
import com.stackroute.quizify.userregistrationservice.domain.User;
import com.stackroute.quizify.userregistrationservice.exceptions.UserAlreadyExistException;
import com.stackroute.quizify.userregistrationservice.exceptions.UserNameExistException;
import com.stackroute.quizify.userregistrationservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class FeedDataApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    private UserService userService;

    @Autowired
    public FeedDataApplicationListener(UserService userService, Producer producer) {
        this.userService = userService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event)
    {
        User user = new User();
        user.setId(0);
        user.setName("dummy");
        user.setEmailId("dummy@gmail.com");
        user.setPassword("12345");
        user.setTopics(new ArrayList<>());
        user.setGenres(new ArrayList<>());
        user.setGamesPlayed(new ArrayList<>());
        user.setGender("male");
        try
        {
            this.userService.saveUser(user);
        }
        catch (UserAlreadyExistException | UserNameExistException e)
        {
            e.printStackTrace();
        }
    }
}
