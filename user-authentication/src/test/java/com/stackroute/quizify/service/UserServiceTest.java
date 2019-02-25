package com.stackroute.quizify.service;

import com.stackroute.quizify.domain.User;
import com.stackroute.quizify.repository.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    private User user;

    //Create a mock for UserRepositoryTest
    @Mock
    private UserRepository userRepository;

    //Inject the mocks as dependencies into UserServiceImpl
    @InjectMocks
    private UserServiceImpl userService;
    List<User> list= null;

    @Before
    public void setUp() throws Exception {

        //Initialising the mock object
        MockitoAnnotations.initMocks(this);
        user = new User();
        user.setUsername("admin");
        user.setPassword("123");
        user.setRole("admin");

        list = new ArrayList<>();
        list.add(user);

    }

    @Test
    public void getAllUserSuccess(){

        userRepository.save(user);
        //stubbing the mock to return specific data
        when(userRepository.findAll()).thenReturn(list);
        List<User> userlist = userService.getAllUsers();
        Assert.assertEquals(list,userlist);
    }
@Test
    public void getAllUserFailure(){

        User user1 = new User();
        user1.setUsername("admin");
        user1.setPassword("123");
        user1.setRole("admin");

        list = new ArrayList<>();
        list.add(user1);
        userRepository.save(user1);
        //stubbing the mock to return specific data
        when(userRepository.findAll()).thenReturn(list);
        List<User> userlist = userService.getAllUsers();
        Assert.assertEquals(list,userlist);
    }

    @Test
    public void saveUserTestSuccess() throws Exception {

        when(userRepository.save((User)any())).thenReturn(user);
        User savedUser = userService.saveUser(user);
        Assert.assertEquals(user,savedUser);

        //verify here verifies that userRepository save method is only called once
        verify(userRepository,times(1)).save(user);

    }

    @Test
    public void saveUserTestfailure() throws Exception {

        when(userRepository.save((User) any())).thenReturn(null);
        User savedUser = userService.saveUser(user);
        System.out.println("savedUser:" + savedUser);
        Assert.assertNotEquals(user, savedUser);

     /*doThrow(new UserAlreadyExistException()).when(userRepository).findById(eq(101));
     userService.saveUser(user);*/

    }
}