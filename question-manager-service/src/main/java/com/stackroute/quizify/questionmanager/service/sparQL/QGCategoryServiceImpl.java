package com.stackroute.quizify.questionmanager.service.sparQL;


import com.stackroute.quizify.questionmanager.domain.Category;
import com.stackroute.quizify.questionmanager.repository.sparQL.QGCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QGCategoryServiceImpl implements QGCategoryService {
	
	private QGCategoryRepository qgCategoryRepository;

	@Autowired
	public QGCategoryServiceImpl(QGCategoryRepository qgCategoryRepository) {
		this.qgCategoryRepository = qgCategoryRepository;
	}

	@Override
	public Category addCategory(Category category) {
		qgCategoryRepository.save(category);
		return category;
	}

	@Override
	public Iterable<Category> findAllCategories() {
		Iterable<Category> categoryList = qgCategoryRepository.findAll();
		return categoryList;
	}

	@Override
	public Category findCategoryId(long categoryId) {
		Category foundCategory = qgCategoryRepository.findById(categoryId);
		return foundCategory;
	}

	@Override
	public Category findByCategoryName(String categoryName) {
		Category foundByCategoryName = qgCategoryRepository.findByName(categoryName);
		return foundByCategoryName;
	}

	@Override
	public Category updateByCategoryId(Category category) {
		return qgCategoryRepository.save(category);
	}
}