package com.stackroute.quizify.questionmanager.controller.sparQL;

import com.stackroute.quizify.questionmanager.domain.Category;
import com.stackroute.quizify.questionmanager.domain.Topic;
import com.stackroute.quizify.questionmanager.service.sparQL.QGCategoryService;
import com.stackroute.quizify.questionmanager.service.sparQL.QGTopicService;
import io.micrometer.core.annotation.Timed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin("*")
@RequestMapping("/api/v1/question-generator")
@RestController
public class QGController {

	@Autowired
	private QGCategoryService qGCategoryService;
	@Autowired
	private QGTopicService qGTopicService;



	/*
	 * Post a new category
	 */
	@Timed(value = "qg.post.categories", histogram = true, percentiles = { 0.95 }, extraTags = { "version", "1.0" })
	@RequestMapping(value = "/category", method = RequestMethod.POST)
	public ResponseEntity<Category> addCategory(@RequestBody Category category) {
		Category newCategory = qGCategoryService.addCategory(category);

		Category cat = new Category();
		cat.setId(category.getId());
		cat.setName(category.getName());
		cat.setImageUrl(category.getImageUrl());

		return new ResponseEntity<Category>(newCategory, HttpStatus.OK);
	}

	/*
	 * Get all Categories
	 */
	@Timed(value = "qg.get.categories", histogram = true, percentiles = { 0.95 }, extraTags = { "version", "1.0" })
	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public ResponseEntity<Iterable<Category>> getAllCategories() {
		Iterable<Category> allCategories = qGCategoryService.findAllCategories();

		return new ResponseEntity<Iterable<Category>>(allCategories, HttpStatus.OK);
	}

	/*
	 * Get a category by ID
	 */
	@RequestMapping(value = "/categoryId/{categoryId}", method = RequestMethod.GET)
	public ResponseEntity<Category> findByCategoryId(@PathVariable(value = "categoryId") int categoryId) {
		Category foundCategoryById = qGCategoryService.findCategoryId(categoryId);
		return new ResponseEntity<Category>(foundCategoryById, HttpStatus.OK);
	}
	
//	@RequestMapping(value = "categoryId/{categoryId}", method = RequestMethod.DELETE)
//	public ResponseEntity<Void> delete(@PathVariable(value = "categoryId") int categoryId) {
//		repo.deleteById(categoryId);
//		return new ResponseEntity<Void>(HttpStatus.OK);
//	}

	/*
	 * Get a category by Name
	 */
	@Timed(value = "qg.getByName.categories", histogram = true, percentiles = { 0.95 }, extraTags = { "version", "1.0" })
	@RequestMapping(value = "/category/{categoryName}", method = RequestMethod.GET)
	@Timed(value = "qg.get.categoriesByName", percentiles = { 0.95 }, extraTags = { "version", "1.0" })
	public ResponseEntity<Category> findByCategoryName(@PathVariable(value = "categoryName") String categoryName) {
		Category foundCategoryByName = qGCategoryService.findByCategoryName(categoryName);
		return new ResponseEntity<Category>(foundCategoryByName, HttpStatus.OK);
	}

	/*
	 * Post a new category
	 */
	@Timed(value = "qg.post.topics", histogram = true, percentiles = { 0.95 }, extraTags = { "version", "1.0" })
	@RequestMapping(value = "/topic", method = RequestMethod.POST)
	public ResponseEntity<Topic> addTopic(@RequestBody Topic topic) {
		Topic newTopic = qGTopicService.addTopic(topic);

		Topic cat = new Topic();
		cat.setId(topic.getId());
		cat.setName(topic.getName());
		cat.setImageUrl(topic.getImageUrl());

		return new ResponseEntity<Topic>(newTopic, HttpStatus.OK);
	}

	/*
	 * Get all Categories
	 */
	@Timed(value = "qg.get.topics", histogram = true, percentiles = { 0.95 }, extraTags = { "version", "1.0" })
	@RequestMapping(value = "/topic", method = RequestMethod.GET)
	public ResponseEntity<Iterable<Topic>> getAllTopics() {
		Iterable<Topic> allTopics = qGTopicService.findAllTopics();

		return new ResponseEntity<Iterable<Topic>>(allTopics, HttpStatus.OK);
	}

}
