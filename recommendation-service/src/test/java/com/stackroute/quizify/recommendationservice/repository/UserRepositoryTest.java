//package com.stackroute.quizify.recommendationservice.repository;
//
//import com.netflix.discovery.converters.Auto;
//import com.stackroute.quizify.recommendationservice.domain.Genre;
//import com.stackroute.quizify.recommendationservice.domain.Topic;
//import com.stackroute.quizify.recommendationservice.domain.User;
//import lombok.AllArgsConstructor;
//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.data.neo4j.DataNeo4jTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.Assert.*;
//
//@RunWith(SpringRunner.class)
//@DataNeo4jTest
//public class UserRepositoryTest {
//
//    @Autowired
//    private UserRepository userRepository;
//    @Autowired
//    private User user;
//
//    @Before
//    public void setUp() throws Exception {
//        user = new User();
//        user.setId(1);
//        user.setName("John");
//        user.setGender("male");
//        List<Genre> genreList=new ArrayList<>();
//        Genre genre1=new Genre(1,"comedy","imageURL");
//        Genre genre2=new Genre(2,"drama","imageURL");
//        genreList.add(genre1);
//        genreList.add(genre2);
//        user.setGenres(genreList);
//        List<Topic> topicList=new ArrayList<>();
//        Topic topic1=new Topic(1,"Tvshows","imageUrl");
//        Topic topic2=new Topic(2,"Movies","imageurl");
//        topicList.add(topic1);
//        topicList.add(topic2);
//        user.setTopics(topicList);
//    }
//
//    @After
//    public void tearDown() throws Exception {
//        userRepository.deleteAllNodes();
//    }
//
//
//    @Test
//    public void testSaveUser(){
//        System.out.println(userRepository.save(user));
//        User fetchUser = userRepository.getNode(user.getId());
//        Assert.assertEquals(1,fetchUser.getId());
//
//    }
//
////    @Test
////    public void testSaveUserFailure(){
////        User testUser = new User("Harry","john",34,"Harry123",201);
////        userRepository.save(user);
////        User fetchUser = userRepository.findById(user.getId()).get();
////        Assert.assertNotSame(testUser,user);
////    }
//
//}
