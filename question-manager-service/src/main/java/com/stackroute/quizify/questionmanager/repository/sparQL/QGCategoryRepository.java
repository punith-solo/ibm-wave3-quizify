package com.stackroute.quizify.questionmanager.repository.sparQL;



import com.stackroute.quizify.questionmanager.domain.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QGCategoryRepository extends MongoRepository<Category, Long> {

	Category findByName(String categoryName);

	Category findById(long id);

}
