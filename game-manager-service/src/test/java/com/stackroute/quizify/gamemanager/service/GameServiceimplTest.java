//package com.stackroute.quizify.gamemanager.service;
//
//import com.stackroute.quizify.gamemanager.exception.GameAlreadyExists;
//import com.stackroute.quizify.gamemanager.exception.GameNotFound;
//import com.stackroute.quizify.gamemanager.repository.GameRepository;
//import com.stackroute.quizify.gamemanager.domain.*;
//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.mockito.Mockito.doNothing;
//import static org.mockito.Mockito.doReturn;
//
//
//public class GameServiceimplTest  {
//
//
//    @Mock
//    GameRepository gameRepository;
//    Topic topic;
//    Admin admin;
//    Game gameobj;
//    Category category;
//    Question question;
//
//    @InjectMocks
//    GameService gameService;
//
//    @Before
//    public void setUp() throws Exception {
//        category=new Category();
//        question= new Question();
//    }
//
//    @After
//    public void tearDown() throws Exception {
//
//    }
//
//
//
//
//    @Test
//    public void saveGame() throws GameAlreadyExists {
//
//
//        List<Question> questions =new ArrayList<>();
//        questions.add(question);
//
//        Game game = new Game(1,"game1",category,topic,20,8,questions,admin,"medium");
//        doReturn(false).when(gameRepository).existsById(game.getId());
//        doReturn(game).when(gameRepository).save(game);
//        Assert.assertEquals(gameService.saveGame(game),game);
//    }
//
//    @Test
//    public void deleteGame() throws GameNotFound {
//
//        List<Question> questions =new ArrayList<>();
//        questions.add(question);
//
//        Game game1 = new Game(1,"game1",category,topic,3,6,questions,admin,"easy");
//        doReturn(true).when(gameRepository).existsById(game1.getId());
//        doNothing().when(gameRepository).deleteById(game1.getId());
//        Assert.assertEquals(gameService.deleteGame(game1), "2");
//    }
//
//    @Test
//    public void updateGame() throws GameNotFound{
//
//        List<Question> questions =new ArrayList<>();
//        questions.add(question);
//
//        Game game = new Game(1,"game1",category,topic,3,4,questions,admin,"easy");
//        doReturn(true).when(gameRepository).existsById(game.getId());
//        doReturn(game).when(gameRepository).findById(game.getId());
//        doReturn(game).when(gameRepository).save(game);
//        Assert.assertEquals(gameService.updateGame(game), game);
//    }
//}