package com.stackroute.quizify.questionmanager.repository.sparQL;


import com.stackroute.quizify.questionmanager.domain.Topic;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QGTopicRepository extends MongoRepository<Topic, Long> {

	Topic findByName(String topicName);

	Topic findById(long topicId);

}
