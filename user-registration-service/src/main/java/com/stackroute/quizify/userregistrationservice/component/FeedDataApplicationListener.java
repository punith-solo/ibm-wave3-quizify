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
        user.setName("kaustav");
        user.setEmailId("kaustavlogan@gmail.com");
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

        user = new User();
        user.setId(0);
        user.setName("dummy");
        user.setEmailId("dummy@gmail.com");
        user.setPassword("123");
        user.setTopics(new ArrayList<>());
        user.setGenres(new ArrayList<>());
        user.setGamesPlayed(new ArrayList<>());
        user.setGender("female");

        try
        {
            this.userService.saveUser(user);
        }
        catch (UserAlreadyExistException | UserNameExistException e)
        {
            e.printStackTrace();
        }

        user = new User();
        user.setId(0);
        user.setName("madhu");
        user.setEmailId("madhu@gmail.com");
        user.setPassword("12345");
        user.setTopics(new ArrayList<>());
        user.setGenres(new ArrayList<>());
        user.setGamesPlayed(new ArrayList<>());
        user.setGender("female");

        try
        {
            this.userService.saveUser(user);
        }
        catch (UserAlreadyExistException | UserNameExistException e)
        {
            e.printStackTrace();
        }

        user = new User();
        user.setId(0);
        user.setName("vinay");
        user.setEmailId("vingu@gmail.com");
        user.setPassword("1234567890");
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

        user = new User();
        user.setId(0);
        user.setName("akhila");
        user.setEmailId("akhila@gmail.com");
        user.setPassword("1234567");
        user.setTopics(new ArrayList<>());
        user.setGenres(new ArrayList<>());
        user.setGamesPlayed(new ArrayList<>());
        user.setGender("female");

        try
        {
            this.userService.saveUser(user);
        }
        catch (UserAlreadyExistException | UserNameExistException e)
        {
            e.printStackTrace();
        }

        user = new User();
        user.setId(0);
        user.setName("pratyush");
        user.setEmailId("pratyush@gmail.com");
        user.setPassword("1234567890");
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

        user = new User();
        user.setId(0);
        user.setName("guest");
        user.setEmailId("guest@mail.com");
        user.setPassword("1234567890");
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
