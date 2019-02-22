//package com.stackroute.quizify.questionmanager.kafka;
//
//import com.stackroute.quizify.questionmanager.domain.Admin;
//import com.stackroute.quizify.questionmanager.domain.Category;
//import com.stackroute.quizify.questionmanager.domain.Question;
//import com.stackroute.quizify.questionmanager.domain.Topic;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.kafka.test.context.EmbeddedKafka;
//import org.springframework.messaging.handler.annotation.Payload;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.Assert.assertEquals;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@DirtiesContext
////@EmbeddedKafka(topics = "questions", brokerProperties = {"listeners=PLAINTEXT://127.0.0.1:9092", "port=2181"})
//public class KafkaTest {
//    @Autowired
//    private Producer producer;
//
//    @Autowired
//    private Consumer consumer;
//
//    @Test
//    public void testProducerConsumer()
//    {
//        Question sentPayload = producer.getPayload();
//        Question recievedPayload = consumer.getRecievedPayload();
//
//        assertEquals(sentPayload, recievedPayload);
//    }
//}
