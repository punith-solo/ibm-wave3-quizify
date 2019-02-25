//package com.stackroute.repository;
//
//import User;
//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.test.context.junit4.SpringRunner;
//import UserRepository;
//import java.util.List;
//
//import static org.junit.Assert.*;
//
//@RunWith(SpringRunner.class)
//@DataJpaTest
//public class UserRepositoryTest {
//
//
//    @Autowired
//    private UserRepository userRepository;
//    private User user;
//
//
//    @Before
//    public void setUp() {
////        user = new User();
////        user.setUsername("ADMIN");
////        user.setPassword("123");
////        user.setRole("admin");
////        userRepository.save(user);
//    }
//
//
//    @Test
//    public void testSaveUser(){
////        userRepository.save(user);
////        User fetchUser = userRepository.findById(user.getUsername()).get();
////        Assert.assertEquals("ADMIN",fetchUser.getUsername());
//
//    }
//
//    @Test
//    public void testGetAllTrack(){
////        User u = new User("jass","123","player");
////        User u1 = new User("kaur","789","player");
////        userRepository.save(u);
////        userRepository.save(u1);
////
////        List<User> list = userRepository.findAll();
////        Assert.assertEquals("player",list.get(1).getRole());
//
//
//
//
//    }
//    @Test
//    public void testSaveTrackFailure(){
////        User testUser = new User("hello","Hello","hello");
////        userRepository.save(user);
////        User fetchUser = userRepository.findById(user.getUsername()).get();
////        Assert.assertNotEquals(testUser,user);
//    }
//}