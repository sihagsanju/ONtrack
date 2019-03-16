package com.stackroute.recommendationservice.service;

import com.stackroute.rabbitmq.domain.Category;

import java.util.List;

public interface CategoryService {
    public List<Category> getAllCategories();
    public Category createNode(Category category);
}
