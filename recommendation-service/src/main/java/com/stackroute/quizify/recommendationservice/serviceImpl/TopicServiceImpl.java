package com.stackroute.quizify.recommendationservice.serviceImpl;

import com.stackroute.quizify.recommendationservice.domain.Topics;
import com.stackroute.quizify.recommendationservice.repository.TopicRepository;
import com.stackroute.quizify.recommendationservice.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicServiceImpl implements TopicService {

    private TopicRepository topicRepository;

    @Autowired
    public TopicServiceImpl(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    @Override
    public List<Topics> getAllTopicsforCategory(long categoryId) {
        return topicRepository.getAllNodesforCategory(categoryId);
    }

    @Override
    public List<Topics> getAll() {
        return topicRepository.getAllNodes();
    }
}
