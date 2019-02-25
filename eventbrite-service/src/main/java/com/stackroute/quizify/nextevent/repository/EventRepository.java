package com.stackroute.quizify.nextevent.repository;

import com.stackroute.quizify.nextevent.model.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends MongoRepository<Event, String> {

    Event findByEventId(String id);

}

