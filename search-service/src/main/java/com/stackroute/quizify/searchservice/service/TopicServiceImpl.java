package com.stackroute.quizify.searchservice.service;

import com.stackroute.quizify.searchservice.domain.Topics;
import com.stackroute.quizify.searchservice.exception.TopicDoesNotExistsException;
import com.stackroute.quizify.searchservice.exception.TopicAlreadyExistsException;
import com.stackroute.quizify.searchservice.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * This "TopicServiceImpl" Class implements all the methods declared by "TopicService" Interface.
 *
 * Spring @Service annotation is used with classes that provide business functionalities/logics.
 */

@Service
public class TopicServiceImpl implements TopicService{

    private TopicRepository topicRepository;

    @Autowired
    public TopicServiceImpl(TopicRepository topicRepository){
        this.topicRepository=topicRepository;
    }


    @Override
    public Topics saveTopic(Topics topics) throws TopicAlreadyExistsException {
        if (this.topicRepository.existsById(topics.getId()))
            throw new TopicAlreadyExistsException();
        else
        {
            if(this.topicRepository.findTopByOrderByIdDesc().isEmpty())
                topics.setId(1);
            else
                topics.setId(this.topicRepository.findTopByOrderByIdDesc().get().getId()+1);
            return topicRepository.save(topics);
        }
    }

    @Override
    public List<Topics> getAllTopicByStartsWith(String topicName) throws TopicDoesNotExistsException {
        List<Topics> topics = topicRepository.searchByTopicAlphabet(topicName);
        if(topics==null)
            throw new TopicDoesNotExistsException();
        else
            return topics;
    }

}
