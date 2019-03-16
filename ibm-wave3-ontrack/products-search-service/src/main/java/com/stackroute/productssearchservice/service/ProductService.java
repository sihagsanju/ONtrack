package com.stackroute.productssearchservice.service;

import com.stackroute.productssearchservice.domain.Brand;
import com.stackroute.productssearchservice.domain.Product;
import com.stackroute.productssearchservice.exception.BrandDoesNotExists;
import com.stackroute.productssearchservice.exception.ProductAlreadyExistsException;
import com.stackroute.productssearchservice.exception.ProductDoesNotExistsException;

import java.util.List;
import java.util.Optional;

/*
 * This "ProductService" Interface is used to declare all the necessary services/methods
 * which are must be implemented by the Implementing Class (ProductServiceImpl).
 */


public interface ProductService {
    Optional<Brand> saveProduct(Product product) throws ProductAlreadyExistsException;
    List<Product> getAllProductByStartswith(String productName) throws ProductDoesNotExistsException;
    List<Product> getAllProductsByStartwithbrand(String brand) throws BrandDoesNotExists;
}
