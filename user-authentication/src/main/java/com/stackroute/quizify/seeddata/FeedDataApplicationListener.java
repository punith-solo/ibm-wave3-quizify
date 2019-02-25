package com.stackroute.quizify.seeddata;

import com.stackroute.quizify.domain.User;
import com.stackroute.quizify.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;


//@Component
//@Data
//@Primary
@Configuration
public class FeedDataApplicationListener implements ApplicationListener<ContextRefreshedEvent> {
    private UserRepository userRepository;


    @Autowired
    public FeedDataApplicationListener(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent)
    {
        userRepository.save(new User("admin", "123", "admin"));
        userRepository.save(new User("player1", "123", "player"));
        userRepository.save(new User("player2", "123", "player"));
        userRepository.save(new User("player3", "123", "player"));
    }


}
