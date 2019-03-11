//package com.stackroute.quizify.userregistrationservice.Controller;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import com.stackroute.quizify.userregistrationservice.controller.UserController;
//import com.stackroute.quizify.userregistrationservice.domain.Genre;
//import com.stackroute.quizify.userregistrationservice.domain.Topic;
//import com.stackroute.quizify.userregistrationservice.domain.User;
//import com.stackroute.quizify.userregistrationservice.repository.UserRepository;
//import com.stackroute.quizify.userregistrationservice.service.UserService;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//
//import static junit.framework.TestCase.assertTrue;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.anyLong;
//import static org.mockito.Matchers.anyInt;
//import static org.mockito.Mockito.when;
//
//
//@RunWith(SpringRunner.class)
//@WebMvcTest
//public class UserControllerTest {
//    @Autowired
//    private MockMvc mockMvc;
//    private User user;
//    private UserRepository userRepository;
//
//    @MockBean
//    private UserService userService;
//
//    @InjectMocks
//    private UserController userController;
//
//    private List<User> list = null;
//
//    @Before
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
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
//    }
//    @Test
//    public void saveUser() throws Exception {
////        when(userService.saveUser(any())).thenReturn(user);
////        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/user")
////                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(user)))
////                .andExpect(MockMvcResultMatchers.status().isCreated())
////                .andDo(MockMvcResultHandlers.print());
////        =this.userMapper.userDTOToUser(userDTO);
//        when(userService.saveUser(any())).thenReturn(user);
//        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/user")
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(user)))
//                .andExpect(MockMvcResultMatchers.status().isCreated())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    @Test
//    public void updateUser() throws Exception
//    {
//        when(userService.updateUser(any())).thenReturn(user);
//        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/user")
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(user)))
//                .andExpect(MockMvcResultMatchers.status().isCreated())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    @Test
//    public void getUser() throws Exception
//    {
//
//        when(userService.getAllUsers()).thenReturn(list);
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/user")
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(user)))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//    }
////    @Test
////        public void deleteUser() {
////        User savedUser = this.userRepository.save(this.user);
////
////        this.userRepository.delete(savedUser);
////        assertTrue(this.userRepository.findById(savedUser.getId()).isEmpty());
////    }
//
//    @Test
//    public void deleteUser() throws Exception
//    {
//        when(userService.deleteUser(anyLong())).thenReturn(user);
//        long id=user.getId();
//        System.out.println(id);
//        System.out.println(userService.saveUser(user));
//        mockMvc.perform(MockMvcRequestBuilders.delete("api/v1/user/11")
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(user)))
//                .andExpect(MockMvcResultMatchers.status().isNotFound())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    private static String asJsonString(final Object obj)
//    {
//        try{
//            return new ObjectMapper().writeValueAsString(obj);
//
//        }catch(Exception e){
//            throw new RuntimeException(e);
//        }
//    }
//
//}
