package com.stackroute.productssearchservice.repository;

import com.stackroute.productssearchservice.domain.Brand;
import com.stackroute.productssearchservice.domain.Product;
import com.stackroute.productssearchservice.exception.BrandDoesNotExists;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface BrandRepository extends MongoRepository<Brand,String> {
    @Query("{ 'brand': { $regex: '?0', $options: 'i'} }")
     Brand searchBrandByName(String brand) throws BrandDoesNotExists;
    @Query("{productName:{ $regex: '?0', $options: 'i'}}")
    List<Product> searchByProductAlphabet(String productName);
}

