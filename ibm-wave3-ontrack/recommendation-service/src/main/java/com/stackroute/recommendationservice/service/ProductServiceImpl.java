package com.stackroute.recommendationservice.service;


import com.stackroute.recommendationservice.Repository.ProductRepository;
import com.stackroute.recommendationservice.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAll()
    {
        return (List<Product>)productRepository.findAll();
    }

    public Product createNode(Product product) {
        String productId = product.getProductId();
        String productName = product.getProductName();
        String productType = product.getProductType();
        String productTypeId = product.getProductTypeId();
        String imageURL = product.getImageURL();
        String mrp = product.getMrp();
        String price = product.getPrice();
        String dimension = product.getDimension();
        String weight = product.getWeight();
        String size = product.getSize();
        String gender = product.getGender();
        String description = product.getDescription();
        String brand = product.getBrand();
        String brandId = product.getBrandId();
        String colour = product.getColour();
        Product node = productRepository.create(productId,productName,productType,productTypeId,imageURL,mrp,price,dimension,weight,size,gender,description,brand,brandId,colour);
        //System.out.println("service : "+node);
        return node;
    }


}

