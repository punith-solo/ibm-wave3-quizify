//package com.stackroute.quizify.userregistrationservice.service;
//
//
//
//import com.stackroute.quizify.userregistrationservice.domain.Genre;
//import com.stackroute.quizify.userregistrationservice.domain.Topic;
//import com.stackroute.quizify.userregistrationservice.domain.User;
//import com.stackroute.quizify.userregistrationservice.exceptions.UserAlreadyExistException;
//import com.stackroute.quizify.userregistrationservice.exceptions.UserNotFoundException;
//import com.stackroute.quizify.userregistrationservice.repository.UserRepository;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.*;
//
//public class UserServiceTest {
//
//    private User user;
//
//    @Mock
//    UserRepository userRepository;
//
//    @InjectMocks
//    UserServiceImpl userService;
//
//
//    @Before
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//        user = new User();
//        this.user.setName("Akhila");
////        this.user.setPassword("Good song");
////        this.user.setConfirmPassword("Good song");
//        this.user.setEmailId("akhila@gmail.com");
//        this.user.setGender("F");
//
//        List<Topic> topics = new ArrayList<>();
//        Topic topic1 = new Topic(1, "Movies", "imageurl");
//        topics.add(topic1);
//        Topic topic2 = new Topic(2, "TvShows", "imageurl");
//        topics.add(topic2);
//        this.user.setTopics(topics);
//
//        List<Genre> genres = new ArrayList<>();
//        Genre genre1 = new Genre(1, "comedy", "imageurl");
//        genres.add(genre1);
//        Genre genre2 = new Genre(2, "action", "imageurl");
//        genres.add(genre2);
//        this.user.setGenres(genres);
//
//
//    }
//
//    @Test
//    public void saveUserTest() throws UserAlreadyExistException {
//        when(this.userRepository.existsById((Long) any())).thenReturn(true);
//        when(this.userRepository.save((User) any())).thenReturn(this.user);
//
////        verify(this.userRepository, times(1)).existsById(((Long) any()));
//        verify(this.userRepository, times(1)).save((User) any());
//
//
//        when(userRepository.save(any())).thenReturn(user);
//        User savedUser = userService.saveUser(user);
//        System.out.println(savedUser);
//        Assert.assertEquals(user, savedUser);
//
//        //verify here verifies that userRepository save method is only called once
//        //verify(userRepository,times(1)).save(user);
//
//
//    }
//
//
//    @Test
//    public void getUserTest() {
//        user = new User();
//        this.user.setId(12);
//        this.user.setName("Akhila");
////        this.user.setPassword("Good song");
////        this.user.setConfirmPassword("Good song");
//        this.user.setEmailId("akhila@gmail.com");
//        this.user.setGender("F");
//        List<Topic> topics = new ArrayList<>();
//        Topic topic1 = new Topic(1, "Movies", "imageurl");
//        topics.add(topic1);
//        Topic topic2 = new Topic(2, "TvShows", "imageurl");
//        topics.add(topic2);
//        this.user.setTopics(topics);
//
//        List<Genre> genres = new ArrayList<>();
//        Genre genre1 = new Genre(1, "comedy", "imageurl");
//        genres.add(genre1);
//        Genre genre2 = new Genre(2, "action", "imageurl");
//        genres.add(genre2);
//        this.user.setGenres(genres);
//
//
//    }
//
//    @Test
//    public void updateUserTest() throws UserNotFoundException {
//        when(this.userRepository.existsById((Long) any())).thenReturn(true);
//        when(this.userRepository.save((User) any())).thenReturn(this.user);
//
//
//        User updatedUser = this.userService.updateUser(this.user);
//        assertEquals(this.user, updatedUser);
//
//        verify(this.userRepository, times(1)).existsById(((Long) any()));
//        verify(this.userRepository, times(1)).save((User) any());
//
//
//    }
//
//
//    @Test
//    public void deleteUserTest() throws UserNotFoundException {
////        boolean status = false;
////        if (this.userRepository.existsById(any())) {
////
////            userRepository.deleteById(any());
////            status = true;
////            return status;
////        } else {
////            throw new UserNotFoundException("User not found");
////        }
////    }
////}
//
//        when(this.userRepository.existsById((Long) any())).thenReturn(true);
//        Long id = this.user.getId();
//        User deletedUser = this.userService.deleteUser(id);
//        assertEquals(this.user, deletedUser);
//
//        verify(this.userRepository, times(1)).existsById((Long) any());
//        verify(this.userRepository, times(1)).delete((User) any());
//
//    }
//}
