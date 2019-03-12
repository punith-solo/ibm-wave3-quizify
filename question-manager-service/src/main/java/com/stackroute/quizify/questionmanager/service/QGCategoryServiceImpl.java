package com.stackroute.quizify.questionmanager.service;


import com.stackroute.quizify.questionmanager.domain.Category;
import com.stackroute.quizify.questionmanager.repository.QGCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QGCategoryServiceImpl implements QGCategoryService {

	@Autowired
	private QGCategoryRepository qGRedisRepository;

	@Override
	public Category addCategory(Category category) {
		qGRedisRepository.save(category);
		return category;
	}

	@Override
	public Iterable<Category> findAllCategories() {
		Iterable<Category> categoryList = qGRedisRepository.findAll();
		return categoryList;
	}

	@Override
	public Category findCategoryId(long categoryId) {
		Category foundCategory = qGRedisRepository.findById(categoryId);
		return foundCategory;
	}

	@Override
	public Category findByCategoryName(String categoryName) {
		Category foundByCategoryName = qGRedisRepository.findByName(categoryName);
		return foundByCategoryName;
	}

	@Override
	public Category updateByCategoryId(Category category) {
		return qGRedisRepository.save(category);
	}
}