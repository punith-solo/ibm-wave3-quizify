//package com.example.stackroute.gamemanager.repository;
//
//import com.example.stackroute.gamemanager.domain.*;
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.repository.MongoRepository;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.Assert.*;
//
//public class GameRepositoryTest {
//
//    @Autowired
//    GameRepository gameRepository;
//    Topic topic;
//    Admin admin;
//    Game gameobj;
//    Category category;
//    Question question;
//
//
//    @Before
//    public void setUp() throws Exception {
//         question=new Question();
//         topic=new Topic();
//         admin=new Admin();
//         category= new Category();
//
//    }
//
//    @Test
//    public void saveGametest(){
//
//        //Domain:Question
//
//
//        List<String> op = new ArrayList<>();
//
//
//        op.add("A");
//        op.add("B");
//        op.add("C");
//        op.add("D");
//
//        question.setAnswer("a");
//        question.setId("1");
//        question.setOptions(op);
//        question.setType("MCQ");
//        question.setLevel("easy");
//        question.setStatement("what is your name?");
//        question.setAdmin(admin);
//        List<Question> questions =new ArrayList<>();
//        questions.add(question);
//
//
//        //Topic
//        List<Topic> topics = new ArrayList<>();
//        topics.add(topic);
//
//        topic.setAdmin(admin);
//        topic.setName("java");
//        topic.setImageUrl(".png");
//        topic.setTimeStamp("30");
//        topic.setSubTopics(topics);
//
//
//        //admin
//        admin.setId("111");
//        admin.setName("madhu");
//
//        //category
//
//        category.setName("Technology");
//        category.setImageUrl(".png");
//        category.setTimeStamp("20");
//        category.setAdmin(admin);
//
//
//        gameobj = new Game("g1","game1",category,20,"easy",questions,admin,topic);
//
//        //gameRepository.save(gameobj);
//
//        Optional retrivedGame = gameRepository.findById(gameobj.getId());
//
//        assertEquals(gameobj,retrivedGame);
//
//    }
//}