package com.stackroute.productservice.repository;


import com.stackroute.rabbitmq.domain.Product;
import com.stackroute.rabbitmq.domain.ProductDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends MongoRepository<Product, String> {


}
