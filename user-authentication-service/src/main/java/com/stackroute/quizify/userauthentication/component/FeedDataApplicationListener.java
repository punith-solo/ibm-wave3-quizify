package com.stackroute.quizify.userauthentication.component;

import com.stackroute.quizify.userauthentication.domain.User;
import com.stackroute.quizify.userauthentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
public class FeedDataApplicationListener implements ApplicationListener<ContextRefreshedEvent> {
    private UserRepository userRepository;

    @Autowired
    public FeedDataApplicationListener(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent)
    {
        userRepository.save(new User(0,"admin", "123", "admin"));
    }


}
