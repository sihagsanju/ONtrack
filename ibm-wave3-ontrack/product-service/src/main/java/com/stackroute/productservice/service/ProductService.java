package com.stackroute.productservice.service;


import com.stackroute.rabbitmq.domain.Product;
import com.stackroute.productservice.exceptions.ProductAlreadyExistsException;
import com.stackroute.productservice.exceptions.ProductAlreadyUpdatedException;
import com.stackroute.productservice.exceptions.ProductIdNotFoundException;
import com.stackroute.rabbitmq.domain.ProductDTO;

import java.util.List;

public interface ProductService {
    public Product saveProduct(Product product) throws ProductAlreadyExistsException;
    public Product updateProduct(Product product) throws ProductAlreadyUpdatedException;
    public boolean deleteProduct(String id) throws ProductIdNotFoundException;
    public List<Product> getAllProducts();

}
