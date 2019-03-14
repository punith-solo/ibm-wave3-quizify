package com.stackroute.quizify.questionmanager.service.sparQL;

import com.stackroute.quizify.questionmanager.domain.Category;

public interface QGCategoryService {

	/**
	 * Add new Categories
	 */
	Category addCategory(Category category);

	/**
	 * Return all Categories
	 */
	Iterable<Category> findAllCategories();

	/**
	 * find a Cateogy by id
	 */
	Category findCategoryId(long categoryId);

	/**
	 * find a Cateogy by name
	 */
	Category findByCategoryName(String categoryName);

	/**
	 * Update a Cateogy by Id
	 */
	Category updateByCategoryId(Category category);

}
