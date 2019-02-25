package com.stackroute.quizify.nextevent.repository;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
//@DataMongoTest
@SpringBootTest
public class EventRepositoryTestIt {

    @Test
    public void findByDescription() throws Exception {
        assertEquals("Teaspoon", "Teaspoon");
    }
}

