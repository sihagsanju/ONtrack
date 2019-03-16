package com.stackroute.recommendationservice.service;



import com.stackroute.recommendationservice.domain.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getAll();
    public Product createNode(Product product);
}
