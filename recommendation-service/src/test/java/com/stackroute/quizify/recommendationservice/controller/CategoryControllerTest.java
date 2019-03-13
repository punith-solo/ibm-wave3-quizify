package com.stackroute.quizify.recommendationservice.controller;

import com.stackroute.quizify.recommendationservice.domain.Category;
import com.stackroute.quizify.recommendationservice.service.CategoryService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CategoryControllerTest {

    @Autowired
    CategoryService categoryService;
    Category category;
    List<Category> categoryList=new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        category=new Category(1,"Tvshows","imageurl");
        List<Category> categoryList=new ArrayList<>();
        categoryList.add(category);

    }

    @After
    public void tearDown() throws Exception {
        categoryList=null;
    }

    @Test
    public void getAll() {
        
    }
}