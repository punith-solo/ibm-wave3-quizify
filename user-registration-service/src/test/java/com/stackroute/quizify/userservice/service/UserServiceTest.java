//package com.stackroute.userservice.service;
//
//
//import User;
//import UserAlreadyExistException;
//import UserNotFoundException;
//import UserRepository;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//
//import static org.mockito.Mockito.*;
//
//public class UserServiceTest {
//    User user;
//
//    @Mock
//    UserRepository userRepository;
//
//    @InjectMocks
//    UserServiceImpl userService;
//    List<User> list = null;
//
//    @Before
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//        user = new User();
//        user.setUserId(11);
//        user.setUserName("Akhila");
//        user.setPassword("Good song");
//        user.setConfirmPassword("Good song");
//        user.setEmailId("akhila@gmail.com");
//        user.setInterests(Arrays.asList("movies","tvshows"));
//        user.setGender("F");
//        list.add(user);
//    }
//
//
//    @Test
//    public void saveUserTest() throws UserAlreadyExistException
//    {
//        when(userRepository.save((User)any())).thenReturn(user);
//        User savedUser = userService.saveUser(user);
//        Assert.assertEquals(user,savedUser);
//    }
//
//    @Test
//    public void getUserTest()
//    {
//        userRepository.save(user);
//        when(userRepository.findAll()).thenReturn(list);
//        List<User> userList = userService.getAllUsers();
//        Assert.assertEquals(list,userList);
//    }
//
//    @Test
//    public void updateUserTest() throws UserAlreadyExistException
//    {
//        when(userRepository.save((User)any())).thenReturn(user);
//        User updateUser = new User();
//        try {
//            updateUser = userService.saveUser(user);
//        } catch (UserAlreadyExistException e) {
//            e.printStackTrace();
//        }
//        Assert.assertEquals(user,updateUser);
//    }
//
////    @Test
////    public void deleteUserTest() throws UserNotFoundException
////    {
////        boolean status = false;
////        if (userRepository.existsById(id)) {
////            userRepository.deleteById(id);
////            status = true;
//////            return status;
////        } else {
////            throw new UserNotFoundException("User not found");
////        }
////    }
//
//
//
//
//
//}
