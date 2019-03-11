//package com.stackroute.quizify.userregistrationservice.Repository;
//
//
//import com.stackroute.quizify.userregistrationservice.domain.Genre;
//import com.stackroute.quizify.userregistrationservice.domain.Topic;
//import com.stackroute.quizify.userregistrationservice.domain.User;
//import com.stackroute.quizify.userregistrationservice.repository.UserRepository;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//@RunWith(SpringRunner.class)
//@DataMongoTest
//public class UserRepositoryTest {
//
//    @Autowired
//    private UserRepository userRepository;
//    private User user;
//
//    @Before
//    public void setUp() {
//        user = new User();
//        this.user.setId(11);
//        this.user.setName("Akhila");
//        this.user.setEmailId("akhila@gmail.com");
//        this.user.setGender("F");
//        List<Topic> topics = new ArrayList<>();
//        Topic topic1=new Topic(1,"Movies","imageurl");
//        topics.add(topic1);
//        Topic topic2=new Topic(2,"TvShows","imageurl");
//        topics.add(topic2);
//        this.user.setTopics(topics);
//
//        List<Genre> genres = new ArrayList<>();
//        Genre genre1=new Genre(1,"comedy","imageurl");
//        genres.add(genre1);
//        Genre genre2=new Genre(2,"action","imageurl");
//        genres.add(genre2);
//        this.user.setGenres(genres);
//
//
//    }
//    @Test
//    public void saveUserTest()
//    {
//        userRepository.save(user);
//        User fetchUser = userRepository.findById(user.getId()).get(user);
//        Assert.assertEquals(3,fetchUser.getId());
//    }
//
//    @Test
//    public void getUserTest()
//    {
//        User user = new User(4,"Shreya","sherya@gmail.com","F", Arrays.asList("Movies"), Arrays.asList("action", "historical") );
//        User user1 = new User(5,"sam","sam@gmail.com","F", Arrays.asList("TvShows"), Arrays.asList("comedy", "historical") );
//
//        userRepository.save(user);
//        userRepository.save(user1);
//        List<User> list = userRepository.findAll();
//        Assert.assertEquals(4,list.get(3).getId());
//    }
//
//    @Test
//    public void testSaveUserFailure(){
//        User testUser = new User(2, "kajal", "kajal@gmail.com", Arrays.asList("movies"), Arrays.asList("Thriller", "drama"), "F");
//        userRepository.save(user);
//        User fetchUser = userRepository.findById(user.getId()).get();
//        Assert.assertNotSame(testUser,user);
//    }
//
//
//}