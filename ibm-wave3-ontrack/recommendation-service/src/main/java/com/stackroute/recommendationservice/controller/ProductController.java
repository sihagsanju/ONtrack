package com.stackroute.recommendationservice.controller;

import com.stackroute.recommendationservice.domain.Product;
import com.stackroute.recommendationservice.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/")
public class ProductController {

    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("products")
    public ResponseEntity<?> getAll()
    {
        //System.out.println("aoisGoisa"+productService.getAll() );
        return new ResponseEntity<List<Product>>(productService.getAll(), HttpStatus.OK);
    }

    @PostMapping("product")
    public ResponseEntity<?> create(@RequestBody Product product)
    {
        ResponseEntity responseEntity;
        productService.createNode(product);
        responseEntity = new ResponseEntity<String>("successfully created", HttpStatus.CREATED);
        return responseEntity;
    }
}
