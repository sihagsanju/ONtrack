package com.stackroute.recommendationservice.controller;


import com.stackroute.rabbitmq.domain.Category;
import com.stackroute.recommendationservice.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class CategoryController {

    CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("category")
    public ResponseEntity<?> getAll()
    {
        return new ResponseEntity<List<Category>>(categoryService.getAllCategories(), HttpStatus.OK);
    }

    @PostMapping("category")
    public ResponseEntity<?> create(@RequestBody Category category)
    {
        ResponseEntity responseEntity;
        categoryService.createNode(category);
        responseEntity = new ResponseEntity<String>("successfully created", HttpStatus.CREATED);
        return responseEntity;
    }
}
