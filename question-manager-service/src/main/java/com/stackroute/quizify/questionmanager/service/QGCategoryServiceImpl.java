package com.stackroute.quizify.questionmanager.service;


import com.stackroute.quizify.questionmanager.domain.Category;
import com.stackroute.quizify.questionmanager.repository.QGCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QGCategoryServiceImpl implements QGCategoryService {


//	@Autowired
	private QGCategoryRepository qGCategoryRepository;

	@Autowired
	public QGCategoryServiceImpl(QGCategoryRepository qGCategoryRepository)
	{
		this.qGCategoryRepository = qGCategoryRepository;
	}

	@Override
	public Category addCategory(Category category) {
		qGCategoryRepository.save(category);
		return category;
	}

	@Override
	public Iterable<Category> findAllCategories() {
		Iterable<Category> categoryList = qGCategoryRepository.findAll();
		return categoryList;
	}

	@Override
	public Category findCategoryId(long categoryId) {
		Category foundCategory = qGCategoryRepository.findById(categoryId);
		return foundCategory;
	}

	@Override
	public Category findByCategoryName(String categoryName) {
		Category foundByCategoryName = qGCategoryRepository.findByName(categoryName);
		return foundByCategoryName;
	}

	@Override
	public Category updateByCategoryId(Category category) {
		return qGCategoryRepository.save(category);
	}
}