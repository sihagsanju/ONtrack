package com.stackroute.productssearchservice.repository;

import com.stackroute.productssearchservice.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product,Integer> {
    @Query("{productName:{ $regex: '?0', $options: 'i'}}")
    List<Product> searchByProductAlphabet(String productName);
}
