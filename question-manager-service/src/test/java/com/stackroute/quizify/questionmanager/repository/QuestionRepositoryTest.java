//package com.stackroute.quizify.questionmanager.repository;
//
//import com.stackroute.quizify.questionmanager.domain.Category;
//import com.stackroute.quizify.questionmanager.domain.Genre;
//import com.stackroute.quizify.questionmanager.domain.Question;
//import com.stackroute.quizify.questionmanager.domain.Topic;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.Assert.*;
//
///*
//*This Test Class is used to test the Question Repository CRUD Operations and also Custom Queries.
//*
//*/
//
//@RunWith(SpringRunner.class)
//@DataMongoTest
//public class QuestionRepositoryTest {
//
//    @Autowired
//    private QuestionRepository questionRepository;
//
//
//    private Category category;
//    private Topic topicMovies;
//    private Topic topicTvShows;
//    private Genre action;
//    private Genre documentary;
//    private Question question;
//    private List<Question> questions;
//
//    /*
//    * Setting Up Values for all required objects and lists
//    * Objects will be Initialized before each Test
//    */
//    @Before
//    public void setUp() throws Exception {
//        this.questionRepository.deleteAll();
//
//        /**
//         * Dummy Data For Category Class
//         */
//        this.category = new Category();
//        this.category.setId(202L);
//        this.category.setName("Entertainment");
//        this.category.setImageUrl("https://www.gudstory.com/wp-content/uploads/2018/10/Entertainment-1.jpg");
//
//        /**
//         * Dummy Data For Topic Class
//         */
//        this.topicMovies = new Topic();
//        this.topicMovies.setId(303L);
//        this.topicMovies.setName("Movies");
//        this.topicMovies.setImageUrl("https://boygeniusreport.files.wordpress.com/2016/03/movies-tiles.jpg?quality=98&strip=all");
//
//        this.topicTvShows = new Topic();
//        this.topicTvShows.setId(404L);
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
//        this.question.setId(101);
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
//        /**
//         * Empty List of Question
//         */
//        this.questions = new ArrayList<>();
//    }
//
//    /*
//     * Removing Values from all used objects and lists
//     * Objects will be nullified after each Test
//     */
//    @After
//    public void tearDown() throws Exception {
//        this.questions = null;
//        this.question = null;
//        this.topicTvShows = null;
//        this.topicMovies = null;
//        this.action = null;
//        this.documentary = null;
//        this.category = null;
//
//        this.questionRepository.deleteAll();
//    }
//
//    /*
//     * This Test is to test if A Question is successfully Saved or Not
//     */
//    @Test
//    public void saveQuestionTest() {
//        Question savedQuestion = this.questionRepository.save(this.question);
//        assertEquals(this.question, savedQuestion);
//    }
//
//    /*
//     * This Test is to test if a previously saved question is successfully Updated or Not
//     */
//    @Test
//    public void updateQuestionTest() {
//        Question savedQuestion = this.questionRepository.save(this.question);
//
//        Question updatedQuestion = new Question();
//        updatedQuestion.setId(this.question.getId());
//        updatedQuestion.setCategory(this.category);
//        updatedQuestion.setTopic(this.topicTvShows);
//        updatedQuestion.setGenre(this.documentary);
//        updatedQuestion.setLevel("hard");
//        updatedQuestion.setLevel("t/f");
//        updatedQuestion.setStatement("Joey proposed to Rachel and Phoebe?");
//        List<String> options = new ArrayList<>();
//        options.add("True");
//        options.add("False");
//        updatedQuestion.setOptions(options);
//        Question savedUpdatedQuestion = this.questionRepository.save(updatedQuestion);
//
//        assertNotEquals(savedQuestion, savedUpdatedQuestion);
//    }
//
//    /*
//     * This Test is to test if A Question is successfully Deleted or Not
//     */
//    @Test
//    public void deleteQuestionTest() {
//        Question savedQuestion = this.questionRepository.save(this.question);
//
//        this.questionRepository.delete(savedQuestion);
//        assertFalse(this.questionRepository.existsById(savedQuestion.getId()));
//    }
//
//    @Test
//    public void existsByIdTest() {
//        Question savedQuestion = this.questionRepository.save(this.question);
//
//        assertTrue(this.questionRepository.existsById(savedQuestion.getId()));
//    }
//
//    @Test
//    public void findTopByOrderByIdDescTest() {
//        Question savedQuestion = this.questionRepository.save(this.question);
//
//        assertEquals(savedQuestion, this.questionRepository.findTopByOrderByIdDesc().get());
//    }
//
//
//    @Test
//    public void getQuestionsByTopicTest() {
//        Topic topic = this.question.getTopic();
//
//        Question savedQuestion = this.questionRepository.save(this.question);
//        List<Question> questionList = this.questionRepository.getQuestionsByTopic(topic.getName());
//        assertTrue(questionList.contains(savedQuestion));
//    }
//
//    @Test
//    public void getQuestionsByTopicByLevelTest() {
//        Topic topic = this.question.getTopic();
//        String level = this.question.getLevel();
//
//        Question savedQuestion = this.questionRepository.save(this.question);
//        List<Question> questionList = this.questionRepository.getQuestionsByTopicByLevel(topic.getName(), level);
//        assertTrue(questionList.contains(savedQuestion));
//    }
//
//    @Test
//    public void getQuestionsByGenreByLevelTest() {
//        Genre genre = this.question.getGenre();
//        String level = this.question.getLevel();
//
//        Question savedQuestion = this.questionRepository.save(this.question);
//        List<Question> questionList = this.questionRepository.getQuestionsByGenreByLevel(genre.getName(), level);
//        assertTrue(questionList.contains(savedQuestion));
//    }
//
//    @Test
//    public void getQuestionsByGenreTest() {
//        Genre genre = this.question.getGenre();
//
//        Question savedQuestion = this.questionRepository.save(this.question);
//        List<Question> questionList = this.questionRepository.getQuestionsByGenre(genre.getName());
//        assertTrue(questionList.contains(savedQuestion));
//    }
//
//}