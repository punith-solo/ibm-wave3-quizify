package com.stackroute.quizify.nextevent.service;

import com.stackroute.quizify.nextevent.exception.EventAlreadyExist;
import com.stackroute.quizify.nextevent.exception.EventNotFound;
import com.stackroute.quizify.nextevent.model.Event;

import java.util.List;

public interface EventService {

    Event saveEvent(Event event) throws EventAlreadyExist;

    boolean deleteEvent(String id) throws EventNotFound;

    Event updateEvent(Event event, String id) throws EventNotFound;

    Event getEventById(String id) throws EventNotFound;

    List<Event> getAllEvent() throws EventNotFound;

}
