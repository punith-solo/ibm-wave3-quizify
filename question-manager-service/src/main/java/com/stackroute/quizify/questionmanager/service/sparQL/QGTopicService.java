package com.stackroute.quizify.questionmanager.service.sparQL;

import com.stackroute.quizify.questionmanager.domain.Topic;

public interface QGTopicService {

	/**
	 * Add new Topics
	 */
	Topic addTopic(Topic topic);

	/**
	 * Return all Topics
	 */
	Iterable<Topic> findAllTopics();

	/**
	 * find a Topic by id
	 */
	Topic findTopicId(long topicId);

	/**
	 * find a Topic by name
	 */
	Topic findByTopicName(String topicName);

	/**
	 * Update a Topic by Id
	 */
	Topic updateByTopicId(Topic topic);

}
