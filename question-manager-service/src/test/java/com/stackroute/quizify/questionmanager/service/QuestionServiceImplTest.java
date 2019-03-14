//package com.stackroute.quizify.questionmanager.service;
//
//import com.stackroute.quizify.questionmanager.domain.Category;
//import com.stackroute.quizify.questionmanager.domain.Genre;
//import com.stackroute.quizify.questionmanager.domain.Question;
//import com.stackroute.quizify.questionmanager.domain.Topic;
//import com.stackroute.quizify.questionmanager.exception.EnoughQuestionsNotFound;
//import com.stackroute.quizify.questionmanager.exception.NoQuestionFoundException;
//import com.stackroute.quizify.questionmanager.exception.QuestionAlreadyExistsException;
//import com.stackroute.quizify.questionmanager.exception.QuestionDoesNotExistException;
//import com.stackroute.quizify.questionmanager.repository.QuestionRepository;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.Assert.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//
//public class QuestionServiceImplTest {
//
//    private Category category;
//    private Topic topicMovies;
//    private Topic topicTvShows;
//    private Genre action;
//    private Genre documentary;
//    private Question question;
//    private List<Question> questions;
//
//    @Mock
//    private QuestionRepository questionRepository;
//
//
//    @InjectMocks
//    private QuestionServiceImpl questionService;
//
//    /*
//     * Setting Up Values for all required objects and lists
//     * Objects will be Initialized before each Test
//     */
//    @Before
//    public void setUp() throws Exception {
//        MockitoAnnotations.initMocks(this);
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
//        * Dummy Data For Genre Class
//        */
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
//    }
//
////    ------------------------------------------Test Cases for CRUD Services
//    @Test
//    public void addNewQuestionSuccessTest() throws QuestionAlreadyExistsException {
//        when(this.questionRepository.existsById(anyLong())).thenReturn(false);
//        when(this.questionRepository.findTopByOrderByIdDesc()).thenReturn(Optional.empty());
//        when(this.questionRepository.save(any())).thenReturn(this.question);
//
//        Question savedQuestion = this.questionService.addNewQuestion(this.question);
//        assertEquals(this.question, savedQuestion);
//
//        verify(this.questionRepository, times(1)).existsById(anyLong());
//        verify(this.questionRepository,times(1)).findTopByOrderByIdDesc();
//        verify(this.questionRepository, times(1)).save(any());
//    }
//
//    @Test
//    public void addNewQuestionSuccessTest2() throws QuestionAlreadyExistsException {
//        when(this.questionRepository.existsById(anyLong())).thenReturn(false);
//        when(this.questionRepository.findTopByOrderByIdDesc()).thenReturn(Optional.of(this.question));
//        when(this.questionRepository.save(any())).thenReturn(this.question);
//
//        Question savedQuestion = this.questionService.addNewQuestion(this.question);
//        assertEquals(this.question, savedQuestion);
//
//        verify(this.questionRepository, times(1)).existsById(anyLong());
//        verify(this.questionRepository,times(2)).findTopByOrderByIdDesc();
//        verify(this.questionRepository, times(1)).save(any());
//    }
//
//    @Test(expected = QuestionAlreadyExistsException.class)
//    public void addNewQuestionFailureTest() throws QuestionAlreadyExistsException {
//        when(this.questionRepository.existsById(anyLong())).thenReturn(true);
//
//        Question savedQuestion = this.questionService.addNewQuestion(this.question);
//
//        verify(this.questionRepository, times(1)).existsById(anyLong());
//
//    }
//
//    @Test
//    public void updateQuestionSuccessTest() throws QuestionDoesNotExistException {
//        when(this.questionRepository.existsById(anyLong())).thenReturn(true);
//        when(this.questionRepository.save(any())).thenReturn(this.question);
//
//        Question updatedQuestion = this.questionService.updateQuestion(this.question);
//        assertEquals(this.question, updatedQuestion);
//
//        verify(this.questionRepository, times(1)).existsById(anyLong());
//        verify(this.questionRepository, times(1)).save(any());
//    }
//
//    @Test(expected = QuestionDoesNotExistException.class)
//    public void updateQuestionFailureTest() throws QuestionDoesNotExistException {
//        when(this.questionRepository.existsById(anyLong())).thenReturn(false);
//
//        Question savedQuestion = this.questionService.updateQuestion(this.question);
//
//        verify(this.questionRepository, times(1)).existsById(anyLong());
//    }
//
//    @Test
//    public void removeQuestionSuccessTest() throws QuestionDoesNotExistException {
//        when(this.questionRepository.existsById(anyLong())).thenReturn(true);
//        when(this.questionRepository.findById(anyLong())).thenReturn(this.question);
//
//        Question updatedQuestion = this.questionService.removeQuestion(this.question.getId());
//        assertEquals(this.question, updatedQuestion);
//
//        verify(this.questionRepository, times(1)).existsById(anyLong());
//        verify(this.questionRepository, times(1)).findById(anyLong());
//        verify(this.questionRepository, times(1)).delete(any());
//    }
//
//    @Test(expected = QuestionDoesNotExistException.class)
//    public void removeQuestionFailureTest() throws QuestionDoesNotExistException {
//        when(this.questionRepository.existsById(anyLong())).thenReturn(false);
//
//        this.questionService.removeQuestion(this.question.getId());
//
//        verify(this.questionRepository, times(1)).existsById(anyLong());
//    }
//
//
////    -----------------------------------------------------------Test Cases for getting Questions by Topic
//
//    @Test
//    public void getQuestionsByTopicByLevelSuccessTest() throws EnoughQuestionsNotFound, NoQuestionFoundException {
//        Topic topic = this.question.getTopic();
//        String level = this.question.getLevel();
//
//        this.questions.add(this.question);
//        when(this.questionRepository.getQuestionsByTopicByLevel(any(), any())).thenReturn(this.questions);
//        List<Question> questionList = this.questionService.getQuestionsByTopicByLevel(topic.getName(), level, 1);
//
//        assertTrue(questionList.contains(this.question));
//
//        verify(this.questionRepository, times(1)).getQuestionsByTopicByLevel(any(), any());
//
//    }
//
//    @Test(expected = NoQuestionFoundException.class)
//    public void getQuestionsByTopicByLevelFailureTest() throws NoQuestionFoundException, EnoughQuestionsNotFound {
//        Topic topic = this.question.getTopic();
//        String level = this.question.getLevel();
//
//        when(this.questionRepository.getQuestionsByTopicByLevel(any(), any())).thenReturn(this.questions);
//        List<Question> questionList = this.questionService.getQuestionsByTopicByLevel(topic.getName(), level, 1);
//
//        assertFalse(questionList.contains(this.question));
//
//        verify(this.questionRepository, times(1)).getQuestionsByTopicByLevel(any(), any());
//    }
//
//    @Test(expected = EnoughQuestionsNotFound.class)
//    public void getQuestionsByTopicByLevelFailureTest2() throws NoQuestionFoundException, EnoughQuestionsNotFound {
//        Topic topic = this.question.getTopic();
//        String level = this.question.getLevel();
//
//        this.questions.add(this.question);
//
//        when(this.questionRepository.getQuestionsByTopicByLevel(any(), any())).thenReturn(this.questions);
//        List<Question> questionList = this.questionService.getQuestionsByTopicByLevel(topic.getName(), level, 2);
//
//        assertFalse(questionList.contains(this.question));
//
//        verify(this.questionRepository, times(1)).getQuestionsByTopicByLevel(any(), any());
//    }
//
//
//    @Test
//    public void getQuestionsByTopicSuccessTest() throws NoQuestionFoundException, EnoughQuestionsNotFound {
//        Topic topic = this.question.getTopic();
//
//        this.questions.add(this.question);
//        when(this.questionRepository.getQuestionsByTopic(any())).thenReturn(this.questions);
//        List<Question> questionList = this.questionService.getQuestionsByTopic(topic.getName(), 1);
//
//        assertTrue(questionList.contains(this.question));
//
//        verify(this.questionRepository, times(1)).getQuestionsByTopic(any());
//
//    }
//
//    @Test(expected = NoQuestionFoundException.class)
//    public void getQuestionsByTopicFailureTest() throws NoQuestionFoundException, EnoughQuestionsNotFound {
//        Topic topic = this.question.getTopic();
//
//        when(this.questionRepository.getQuestionsByTopic(any())).thenReturn(this.questions);
//        List<Question> questionList = this.questionService.getQuestionsByTopic(topic.getName(), 1);
//
//        assertFalse(questionList.contains(this.question));
//
//        verify(this.questionRepository, times(1)).getQuestionsByTopic(any());
//    }
//
//    @Test(expected = EnoughQuestionsNotFound.class)
//    public void getQuestionsByTopicFailureTest2() throws NoQuestionFoundException, EnoughQuestionsNotFound {
//        Topic topic = this.question.getTopic();
//
//        this.questions.add(this.question);
//        when(this.questionRepository.getQuestionsByTopic(any())).thenReturn(this.questions);
//        List<Question> questionList = this.questionService.getQuestionsByTopic(topic.getName(), 2);
//
//        assertFalse(questionList.contains(this.question));
//
//        verify(this.questionRepository, times(1)).getQuestionsByTopic(any());
//    }
//
//    @Test
//    public void getAllQuestionsByTopicSuccessTest()throws NoQuestionFoundException
//    {
//        Topic topic = this.question.getTopic();
//
//        this.questions.add(this.question);
//        when(this.questionRepository.getQuestionsByTopic(any())).thenReturn(this.questions);
//        List<Question> questionList = this.questionService.getAllQuestionsByTopic(topic.getName());
//
//        assertTrue(questionList.contains(this.question));
//
//        verify(this.questionRepository, times(1)).getQuestionsByTopic(any());
//
//    }
//
//    @Test(expected = NoQuestionFoundException.class)
//    public void getAllQuestionsByTopicFailureTest()throws NoQuestionFoundException
//    {
//        Topic topic = this.question.getTopic();
//
//        when(this.questionRepository.getQuestionsByTopic(any())).thenReturn(this.questions);
//        List<Question> questionList = this.questionService.getAllQuestionsByTopic(topic.getName());
//
//        assertFalse(questionList.contains(this.question));
//
//        verify(this.questionRepository, times(1)).getQuestionsByTopic(any());
//    }
//
//
//
////    -------------------------------------------------------Test cases for getting questions by Genre
//
//    @Test
//    public void getQuestionsByGenreByLevelSuccessTest() throws NoQuestionFoundException, EnoughQuestionsNotFound {
//        Genre genre = this.question.getGenre();
//        String level = this.question.getLevel();
//
//        this.questions.add(this.question);
//        when(this.questionRepository.getQuestionsByGenreByLevel(any(), any())).thenReturn(this.questions);
//        List<Question> questionList = this.questionService.getQuestionsByGenreByLevel(genre.getName(), level, 1);
//
//        assertTrue(questionList.contains(this.question));
//
//        verify(this.questionRepository, times(1)).getQuestionsByGenreByLevel(any(), any());
//
//    }
//
//    @Test(expected = NoQuestionFoundException.class)
//    public void getQuestionsByGenreByLevelFailureTest() throws NoQuestionFoundException, EnoughQuestionsNotFound {
//        Genre genre = this.question.getGenre();
//        String level = this.question.getLevel();
//
//        when(this.questionRepository.getQuestionsByGenreByLevel(any(), any())).thenReturn(this.questions);
//        List<Question> questionList = this.questionService.getQuestionsByGenreByLevel(genre.getName(), level, 1);
//
//        assertFalse(questionList.contains(this.question));
//
//        verify(this.questionRepository, times(1)).getQuestionsByGenreByLevel(any(), any());
//    }
//
//    @Test(expected = EnoughQuestionsNotFound.class)
//    public void getQuestionsByGenreByLevelFailureTest2() throws NoQuestionFoundException, EnoughQuestionsNotFound {
//        Genre genre = this.question.getGenre();
//        String level = this.question.getLevel();
//
//        this.questions.add(this.question);
//        when(this.questionRepository.getQuestionsByGenreByLevel(any(), any())).thenReturn(this.questions);
//        List<Question> questionList = this.questionService.getQuestionsByGenreByLevel(genre.getName(), level, 2);
//
//        assertFalse(questionList.contains(this.question));
//
//        verify(this.questionRepository, times(1)).getQuestionsByGenreByLevel(any(), any());
//    }
//
//
//    @Test
//    public void getQuestionsByGenreSuccessTest() throws NoQuestionFoundException, EnoughQuestionsNotFound {
//        Genre genre = this.question.getGenre();
//
//        this.questions.add(this.question);
//        when(this.questionRepository.getQuestionsByGenre(any())).thenReturn(this.questions);
//        List<Question> questionList = this.questionService.getQuestionsByGenre(genre.getName(), 1);
//
//        assertTrue(questionList.contains(this.question));
//
//        verify(this.questionRepository, times(1)).getQuestionsByGenre(any());
//
//    }
//
//    @Test(expected = NoQuestionFoundException.class)
//    public void getQuestionsByGenreFailureTest() throws NoQuestionFoundException, EnoughQuestionsNotFound {
//        Genre genre = this.question.getGenre();
//
//        when(this.questionRepository.getQuestionsByGenre(any())).thenReturn(this.questions);
//        List<Question> questionList = this.questionService.getQuestionsByGenre(genre.getName(), 1);
//
//        assertFalse(questionList.contains(this.question));
//
//        verify(this.questionRepository, times(1)).getQuestionsByGenre(any());
//    }
//
//    @Test(expected = EnoughQuestionsNotFound.class)
//    public void getQuestionsByGenreFailureTest2() throws NoQuestionFoundException, EnoughQuestionsNotFound {
//        Genre genre = this.question.getGenre();
//
//        this.questions.add(this.question);
//        when(this.questionRepository.getQuestionsByGenre(any())).thenReturn(this.questions);
//        List<Question> questionList = this.questionService.getQuestionsByGenre(genre.getName(), 2);
//
//        assertFalse(questionList.contains(this.question));
//
//        verify(this.questionRepository, times(1)).getQuestionsByGenre(any());
//    }
//
//
//    @Test
//    public void getAllQuestionsByGenreSuccessTest()throws NoQuestionFoundException
//    {
//        Genre genre = this.question.getGenre();
//
//        this.questions.add(this.question);
//        when(this.questionRepository.getQuestionsByGenre(any())).thenReturn(this.questions);
//        List<Question> questionList = this.questionService.getAllQuestionsByGenre(genre.getName());
//
//        assertTrue(questionList.contains(this.question));
//
//        verify(this.questionRepository, times(1)).getQuestionsByGenre(any());
//
//    }
//
//    @Test(expected = NoQuestionFoundException.class)
//    public void getAllQuestionsByGenreFailureTest()throws NoQuestionFoundException
//    {
//        Genre genre = this.question.getGenre();
//
//        when(this.questionRepository.getQuestionsByGenre(any())).thenReturn(this.questions);
//        List<Question> questionList = this.questionService.getAllQuestionsByGenre(genre.getName());
//
//        assertFalse(questionList.contains(this.question));
//
//        verify(this.questionRepository, times(1)).getQuestionsByGenre(any());
//    }
//
//    @Test
//    public void getQuestionsByTopicByGenreByLevelSuccessTest() throws EnoughQuestionsNotFound, NoQuestionFoundException {
//        Topic topic = this.question.getTopic();
//        Genre genre = this.question.getGenre();
//        String level = this.question.getLevel();
//
//        this.questions.add(this.question);
//        when(this.questionRepository.getQuestionsByTopicByGenreByLevel(any(), any(), any())).thenReturn(this.questions);
//        List<Question> questionList = this.questionService.getQuestionsByTopicByGenreByLevel(topic.getName(), genre.getName(), level, 1);
//
//        assertTrue(questionList.contains(this.question));
//
//        verify(this.questionRepository, times(1)).getQuestionsByTopicByGenreByLevel(any(), any(), any());
//
//
//    }
//
//    @Test(expected = NoQuestionFoundException.class)
//    public void getQuestionsByTopicByGenreByLevelFailureTest() throws EnoughQuestionsNotFound, NoQuestionFoundException {
//        Topic topic = this.question.getTopic();
//        Genre genre = this.question.getGenre();
//        String level = this.question.getLevel();
//
//        when(this.questionRepository.getQuestionsByTopicByGenreByLevel(any(), any(), any())).thenReturn(this.questions);
//        List<Question> questionList = this.questionService.getQuestionsByTopicByGenreByLevel(topic.getName(), genre.getName(), level, 1);
//
//        assertFalse(questionList.contains(this.question));
//
//        verify(this.questionRepository, times(1)).getQuestionsByTopicByGenreByLevel(any(), any(), any());
//    }
//
//    @Test(expected = EnoughQuestionsNotFound.class)
//    public void getQuestionsByTopicByGenreByLevelFailureTest2() throws EnoughQuestionsNotFound, NoQuestionFoundException {
//        Topic topic = this.question.getTopic();
//        Genre genre = this.question.getGenre();
//        String level = this.question.getLevel();
//
//        this.questions.add(this.question);
//        when(this.questionRepository.getQuestionsByTopicByGenreByLevel(any(), any(), any())).thenReturn(this.questions);
//        List<Question> questionList = this.questionService.getQuestionsByTopicByGenreByLevel(topic.getName(), genre.getName(), level, 2);
//
//        assertFalse(questionList.contains(this.question));
//
//        verify(this.questionRepository, times(1)).getQuestionsByTopicByGenreByLevel(any(), any(), any());
//    }
//}