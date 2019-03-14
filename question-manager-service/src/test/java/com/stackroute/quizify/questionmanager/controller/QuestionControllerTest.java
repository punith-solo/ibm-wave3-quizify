//package com.stackroute.quizify.questionmanager.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.stackroute.quizify.questionmanager.domain.Category;
//import com.stackroute.quizify.questionmanager.domain.Genre;
//import com.stackroute.quizify.questionmanager.domain.Question;
//import com.stackroute.quizify.questionmanager.domain.Topic;
//import com.stackroute.quizify.questionmanager.exception.*;
//import com.stackroute.quizify.questionmanager.service.QuestionService;
//import org.junit.After;
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
//import java.util.List;
//
//import static org.mockito.ArgumentMatchers.*;
//import static org.mockito.Mockito.when;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest
//public class QuestionControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private QuestionService questionService;
//
//    @InjectMocks
//    private QuestionController questionController;
//
//    private Category category;
//    private Topic topicMovies;
//    private Topic topicTvShows;
//    private Genre action;
//    private Genre documentary;
//    private Question question;
//    private List<Question> questions;
//
//    @Before
//    public void setUp() throws Exception {
//        MockitoAnnotations.initMocks(this);
//        mockMvc = MockMvcBuilders.standaloneSetup(this.questionController).setControllerAdvice(new GloballyExceptionHandler()).build();
//
//
//        /**
//         * Dummy Data For Category Class
//         */
//        this.category = new Category();
//        this.category.setId(101);
//        this.category.setName("Entertainment");
//        this.category.setImageUrl("https://www.gudstory.com/wp-content/uploads/2018/10/Entertainment-1.jpg");
//
//        /**
//         * Dummy Data For Topic Class
//         */
//        this.topicMovies = new Topic();
//        this.topicMovies.setId(202);
//        this.topicMovies.setName("Movies");
//        this.topicMovies.setImageUrl("https://boygeniusreport.files.wordpress.com/2016/03/movies-tiles.jpg?quality=98&strip=all");
//
//        /**
//         * Dummy Data For Topic Class
//         */
//        this.topicTvShows = new Topic();
//        this.topicTvShows.setId(303);
//        this.topicTvShows.setName("TV-Shows");
//        this.topicTvShows.setImageUrl("http://i-vrox.com/wp-content/uploads/2018/06/series-2.jpg");
//
//        /*
//         * Dummy Data For Genre Class
//         */
//        this.action = new Genre();
//        this.action.setId(3);
//        this.action.setName("Action");
//        this.action.setImageUrl("http://bcheights.com/wp-content/uploads/2017/04/isabella-column-online.jpg");
//
//        this.documentary = new Genre();
//        this.documentary.setId(1);
//        this.documentary.setName("Documentary");
//        this.documentary.setImageUrl("https://www.filmsite.org/images/documentary-genre.jpg");
//
//        /**
//         * Dummy Data For Question Class
//         */
//        this.question = new Question();
//        this.question.setId(0);
//        this.question.setCategory(this.category);
//        this.question.setTopic(this.topicMovies);
//        this.question.setGenre(this.action);
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
//
//        /**
//         * Empty List of Question
//         */
//        this.questions = new ArrayList<>();
//    }
//
//    @After
//    public void tearDown() throws Exception {
//        this.questions = null;
//        this.question = null;
//        this.topicTvShows = null;
//        this.topicMovies = null;
//        this.documentary = null;
//        this.action = null;
//        this.category = null;
//
//    }
//
//    @Test
//    public void saveQuestionSuccessTest() throws Exception {
//        when(this.questionService.addNewQuestion(any())).thenReturn(this.question);
//        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/questions/question")
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(this.question)))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    @Test
//    public void saveQuestionFailureTest() throws Exception {
//        when(this.questionService.addNewQuestion(any())).thenThrow(QuestionAlreadyExistsException.class);
//        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/questions/question")
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(this.question)))
//                .andExpect(MockMvcResultMatchers.status().isConflict())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    @Test
//    public void updateQuestionSuccessTest() throws Exception {
//        when(this.questionService.updateQuestion(any())).thenReturn(this.question);
//        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/questions/question")
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(this.question)))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    @Test
//    public void updateQuestionFailureTest() throws Exception {
//        when(this.questionService.updateQuestion(any())).thenThrow(QuestionDoesNotExistException.class);
//        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/questions/question")
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(this.question)))
//                .andExpect(MockMvcResultMatchers.status().isNotFound())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    @Test
//    public void removeQuestionSuccessTest() throws Exception {
//        when(this.questionService.removeQuestion(anyLong())).thenReturn(this.question);
//        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/questions/question/{id}", this.question.getId())
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(this.question)))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    @Test
//    public void removeQuestionFailureTest() throws Exception {
//        when(this.questionService.removeQuestion(anyLong())).thenThrow(QuestionDoesNotExistException.class);
//        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/questions/question/{id}", this.question.getId())
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(this.question)))
//                .andExpect(MockMvcResultMatchers.status().isNotFound())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
////    ---------------------------------------------Get Questions by Topic
//
//    @Test
//    public void getQuestionsByTopicByLevelSuccessTest() throws Exception {
//        this.questions.add(this.question);
//        Topic topic = this.question.getTopic();
//        String level = this.question.getLevel();
//        int numberOfQuestions = 1;
//        when(this.questionService.getQuestionsByTopicByLevel(any(), any(), anyInt())).thenReturn(this.questions);
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/questions/topic/{topicName}/{level}/{numberOfQuestions}", topic.getName(), level, numberOfQuestions)
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(this.questions)))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    @Test
//    public void getQuestionsByTopicByLevelFailureTest() throws Exception {
//        Topic topic = this.question.getTopic();
//        String level = this.question.getLevel();
//        int numberOfQuestions = 1;
//        when(this.questionService.getQuestionsByTopicByLevel(any(), any(), anyInt())).thenThrow(NoQuestionFoundException.class);
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/questions/topic/{topicName}/{level}/{numberOfQuestions}", topic.getName(), level, numberOfQuestions)
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(this.questions)))
//                .andExpect(MockMvcResultMatchers.status().isNotFound())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    @Test
//    public void getQuestionsByTopicByLevelFailureTest2() throws Exception {
//        this.questions.add(this.question);
//        Topic topic = this.question.getTopic();
//        String level = this.question.getLevel();
//        int numberOfQuestions = 2;
//        when(this.questionService.getQuestionsByTopicByLevel(any(), any(), anyInt())).thenThrow(EnoughQuestionsNotFound.class);
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/questions/topic/{topicName}/{level}/{numberOfQuestions}", topic.getName(), level, numberOfQuestions)
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(this.questions)))
//                .andExpect(MockMvcResultMatchers.status().isNotFound())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    @Test
//    public void getQuestionsByTopicSuccessTest() throws Exception {
//        this.questions.add(this.question);
//        Topic topic = this.question.getTopic();
//        int numberOfQuestions = 1;
//        when(this.questionService.getQuestionsByTopic(any(), anyInt())).thenReturn(this.questions);
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/questions/topic/{topicName}/{numberOfQuestions}", topic.getName(), numberOfQuestions)
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(this.questions)))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    @Test
//    public void getQuestionsByTopicFailureTest() throws Exception {
//        Topic topic = this.question.getTopic();
//        int numberOfQuestions = 1;
//        when(this.questionService.getQuestionsByTopic(any(), anyInt())).thenThrow(NoQuestionFoundException.class);
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/questions/topic/{topicName}/{numberOfQuestions}", topic.getName(), numberOfQuestions)
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(this.questions)))
//                .andExpect(MockMvcResultMatchers.status().isNotFound())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    @Test
//    public void getQuestionsByTopicFailureTest2() throws Exception {
//        this.questions.add(this.question);
//        Topic topic = this.question.getTopic();
//        int numberOfQuestions = 2;
//        when(this.questionService.getQuestionsByTopic(any(), anyInt())).thenThrow(EnoughQuestionsNotFound.class);
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/questions/topic/{topicName}/{numberOfQuestions}", topic.getName(), numberOfQuestions)
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(this.questions)))
//                .andExpect(MockMvcResultMatchers.status().isNotFound())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    @Test
//    public void getAllQuestionsByTopicSuccessTest() throws Exception {
//        this.questions.add(this.question);
//        Topic topic = this.question.getTopic();
//        when(this.questionService.getAllQuestionsByTopic(any())).thenReturn(this.questions);
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/questions/topic/{topicName}", topic.getName())
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(this.questions)))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    @Test
//    public void getAllQuestionsByTopicFailureTest() throws Exception {
//        Topic topic = this.question.getTopic();
//        when(this.questionService.getAllQuestionsByTopic(any())).thenThrow(NoQuestionFoundException.class);
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/questions/topic/{topicName}", topic.getName())
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(this.questions)))
//                .andExpect(MockMvcResultMatchers.status().isNotFound())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
////    -----------------------------------------------------------------Get Questions By Genre
//
//    @Test
//    public void getQuestionsByGenreByLevelSuccessTest() throws Exception {
//        this.questions.add(this.question);
//        Genre genre = this.question.getGenre();
//        String level = this.question.getLevel();
//        int numberOfQuestions = 1;
//        when(this.questionService.getQuestionsByGenreByLevel(any(), any(), anyInt())).thenReturn(this.questions);
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/questions/genre/{genre}/{level}/{numberOfQuestions}", genre.getName(), level, numberOfQuestions)
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(this.questions)))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    @Test
//    public void getQuestionsByGenreByLevelFailureTest() throws Exception {
//        Genre genre = this.question.getGenre();
//        String level = this.question.getLevel();
//        int numberOfQuestions = 1;
//        when(this.questionService.getQuestionsByGenreByLevel(any(), any(), anyInt())).thenThrow(NoQuestionFoundException.class);
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/questions/genre/{genre}/{level}/{numberOfQuestions}", genre.getName(), level, numberOfQuestions)
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(this.questions)))
//                .andExpect(MockMvcResultMatchers.status().isNotFound())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    @Test
//    public void getQuestionsByGenreByLevelFailureTest2() throws Exception {
//        this.questions.add(this.question);
//        Genre genre = this.question.getGenre();
//        String level = this.question.getLevel();
//        int numberOfQuestions = 2;
//        when(this.questionService.getQuestionsByGenreByLevel(any(), any(), anyInt())).thenThrow(EnoughQuestionsNotFound.class);
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/questions/genre/{genre}/{level}/{numberOfQuestions}", genre.getName(), level, numberOfQuestions)
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(this.questions)))
//                .andExpect(MockMvcResultMatchers.status().isNotFound())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    @Test
//    public void getQuestionsByGenreSuccessTest() throws Exception {
//        this.questions.add(this.question);
//        Genre genre = this.question.getGenre();
//        int numberOfQuestions = 1;
//        when(this.questionService.getQuestionsByGenre(any(), anyInt())).thenReturn(this.questions);
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/questions/genre/{genre}/{numberOfQuestions}", genre.getName(), numberOfQuestions)
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(this.questions)))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    @Test
//    public void getQuestionsByGenreFailureTest() throws Exception {
//        Genre genre = this.question.getGenre();
//        int numberOfQuestions = 1;
//        when(this.questionService.getQuestionsByGenre(any(), anyInt())).thenThrow(NoQuestionFoundException.class);
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/questions/genre/{genre}/{numberOfQuestions}", genre.getName(), numberOfQuestions)
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(this.questions)))
//                .andExpect(MockMvcResultMatchers.status().isNotFound())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    @Test
//    public void getQuestionsByGenreFailureTest2() throws Exception {
//        this.questions.add(this.question);
//        Genre genre = this.question.getGenre();
//        int numberOfQuestions = 2;
//        when(this.questionService.getQuestionsByGenre(any(), anyInt())).thenThrow(EnoughQuestionsNotFound.class);
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/questions/genre/{genre}/{numberOfQuestions}", genre.getName(), numberOfQuestions)
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(this.questions)))
//                .andExpect(MockMvcResultMatchers.status().isNotFound())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    @Test
//    public void getAllQuestionsByGenreSuccessTest() throws Exception {
//        this.questions.add(this.question);
//        Genre genre = this.question.getGenre();
//        when(this.questionService.getAllQuestionsByGenre(any())).thenReturn(this.questions);
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/questions/genre/{genre}", genre.getName())
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(this.questions)))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    @Test
//    public void getAllQuestionsByGenreFailureTest() throws Exception {
//        Genre genre = this.question.getGenre();
//        when(this.questionService.getAllQuestionsByGenre(any())).thenThrow(NoQuestionFoundException.class);
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/questions/genre/{genre}", genre.getName())
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(this.questions)))
//                .andExpect(MockMvcResultMatchers.status().isNotFound())
//                .andDo(MockMvcResultHandlers.print());
//    }
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
//}
//
