package com.stackroute.quizify.questionmanager.service;


import com.stackroute.quizify.questionmanager.domain.Topic;
import com.stackroute.quizify.questionmanager.repository.QGTopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QGTopicServiceImpl implements QGTopicService {

//	@Autowired
	private QGTopicRepository qgTopicRepository;

	@Autowired
	public QGTopicServiceImpl(QGTopicRepository qgTopicRepository) {
		this.qgTopicRepository = qgTopicRepository;
	}

	@Override
	public Topic addTopic(Topic topic) {
		return qgTopicRepository.save(topic);
	}

	@Override
	public Iterable<Topic> findAllTopics() {
		return qgTopicRepository.findAll();
	}

	@Override
	public Topic findTopicId(long topicId) {
		return qgTopicRepository.findById(topicId);
	}

	@Override
	public Topic findByTopicName(String topicName) {
		return qgTopicRepository.findByName(topicName);
	}

	@Override
	public Topic updateByTopicId(Topic topic) {
		return qgTopicRepository.save(topic);
	}
}