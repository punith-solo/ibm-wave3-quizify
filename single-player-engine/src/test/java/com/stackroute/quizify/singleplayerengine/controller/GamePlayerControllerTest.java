//package com.stackroute.quizify.singleplayerengine.controller;
//
//import com.stackroute.quizify.kafka.domain.*;
//import com.stackroute.quizify.singleplayerengine.service.PlayerServiceImpl;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
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
//import org.springframework.web.client.RestTemplate;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.Assert.*;
//import static org.mockito.ArgumentMatchers.*;
//import static org.mockito.Mockito.when;
//
//import static org.junit.Assert.*;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest
//
//public class GamePlayerControllerTest {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private PlayerServiceImpl playerServiceImpl;
//
//    @MockBean
//    private RestTemplate restTemplate;
//
//
//    @InjectMocks
//    private GamePlayerController gamePlayerController;
//    private SinglePlayer singlePlayer;
//    private Game game;
//    private Category category;
//    private Topic topic;
//    private Tag tag;
//    private Genre genre;
//    private Question question;
//    private List<Question> questions;
//
//
//
//    @Before
//    public void setUp() throws Exception {
//        MockitoAnnotations.initMocks(this);
//        mockMvc = MockMvcBuilders.standaloneSetup(this.gamePlayerController).build();
//        this.singlePlayer = new SinglePlayer();
//
//
//        /**
//         * Dummy Data For Admin Class
//         */
////        this.admin = new KafkaProperties.Admin();
////        this.admin.setId("101");
////        this.admin.setName("Kaustav");
//
//        /**
//         * Dummy Data For Category Class
//         */
//
//        this.category = new Category();
//        this.category.setName("Entertainment");
//        this.category.setImageUrl("https://www.gudstory.com/wp-content/uploads/2018/10/Entertainment-1.jpg");
////        this.category.setTimeStamp((int)System.currentTimeMillis());
////        this.category.setAdmin(this.admin);
//        /**
//         * Dummy Data For Topic Class
//         */
//        this.topic = new Topic();
//        this.topic.setName("Movies");
//        this.topic.setImageUrl("https://boygeniusreport.files.wordpress.com/2016/03/movies-tiles.jpg?quality=98&strip=all");
////        this.topic.setTimeStamp((int)System.currentTimeMillis());
////        this.topic.setAdmin(this.admin);
//        /**
//         * Dummy Data For Topic Class
//         */
//        this.topic = new Topic();
//        this.topic.setName("TV-Shows");
//        this.topic.setImageUrl("http://i-vrox.com/wp-content/uploads/2018/06/series-2.jpg");
////        this.topic.setTimeStamp((int)System.currentTimeMillis());
////        this.topic.setAdmin(this.admin);
//        this.tag = new Tag();
//        this.tag.setId(111);
//        this.tag.setImageUrl("http://i-vrox.com/wp-content/uploads/2018/06/series-2.jpg");
//        this.tag.setName("gamesOfthrone");
//
//        this.genre = new Genre();
//        this.genre.setId(111);
//        this.genre.setImageUrl("http://i-vrox.com/wp-content/uploads/2018/06/series-2.jpg");
//        this.genre.setName("Horror");
//        /**
//         *
//         * Dummy Data For Question Class
//         */
//        this.question = new Question();
//        this.question.setId(1234567890);
//        this.question.setCategory(this.category);
//        this.question.setTopic(this.topic);
//        this.question.setLevel("easy");
//        this.question.setType("mcq");
//        this.question.setStatement("How many oscars did the Titanic movie got?");
//        List<String> options = new ArrayList<>();
//        options.add("10");
//        options.add("11");
//        options.add("9");
//        options.add("8");
//        this.question.setOptions(options);
//        this.question.setCorrectAnswer("11");
////        this.question.setTimeStamp((int)System.currentTimeMillis());
////        this.question.setAdmin(this.admin);
//        /**
//         * Array List of Question
//         */
//        this.questions = new ArrayList<>();
//        questions.add(question);
//
//        this.game = new Game();
//        this.game.setId(121L);
//        this.game.setName("game1");
//        this.game.setTopic(this.topic);
//        this.game.setCategory(this.category);
////        this.game.setAdmin(this.admin);
//        this.game.setLevel("medium");
//        this.game.setQuestions(questions);
//        this.game.setGenre(this.genre);
//        this.game.setLiked(10);
//        this.game.setPlayCount(5);
//        this.game.setNumOfQuestion(10);
//        this.game.setPlayCount(2);
//        this.game.setTag(this.tag);
//        List<String> rules = new ArrayList<>();
//        rules.add("cannot skip the questions");
//        rules.add("cannot go to the previous questions");
//        rules.add("wrong answers -1 marks");
//        this.game.setRules(rules);
////        this.game.setTimestamp(10);
////        this.game.setRules("you cannot cheat during quiz");
//
//        List<Game> games = new ArrayList<>();
//        games.add(game);
//
//        this.singlePlayer.setPlayerId(12);
//        this.singlePlayer.setGame(game);
//
//    }
//
//    @After
//    public void tearDown() throws Exception {
//            this.questions = null;
//            this.question = null;
//            this.topic = null;
//            this.category = null;
//            this.genre = null;
//            this.tag = null;
//    }
//
//    @Test
//    public void getGame() throws Exception {
//        when(restTemplate.getForObject(anyString(), any())).thenReturn(this.game);
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/user/{playerId}/game/{id}", this.singlePlayer.getPlayerId(), this.singlePlayer.getGame().getId())
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(this.singlePlayer)))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//
//    }
//
//
//
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