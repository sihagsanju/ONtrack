package com.stackroute.recommendationservice.service;

import com.stackroute.rabbitmq.domain.Brand;
import com.stackroute.rabbitmq.domain.Category;

import com.stackroute.recommendationservice.domain.Product;
import com.stackroute.recommendationservice.domain.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqConsumer {
    @Autowired
    CategoryService categoryService;

    @Autowired
    BrandService brandService;

    @Autowired
    ProductService productService;

    @Autowired
    UserService userService;

    Product product;

    User user;

    Category category = new Category();
    Brand brand = new Brand();
    @RabbitListener(queues="${jsa.rabbitmq.queue2}")
    public void recievedMessageFromProduct(Product product) {

        System.out.println("rabbitMq call");
        System.out.println("recieved product: "+product.toString());

        category.setProductType(product.getProductType());
        category.setProductTypeId(product.getProductTypeId());
        categoryService.createNode(category);
        categoryService.getAllCategories();

        System.out.println("recieved : " +category.toString());
        Product product1 = new Product();

        System.out.println("/////////////////////////////////");
        brand.setBrandId(product.getBrandId());
        brand.setBrand(product.getBrand());
        brandService.createBrandNode(brand);
        brandService.getAll();
        System.out.println("brand : " +brand.toString());


        this.product=product;
        System.out.println("***************************");
        productService.createNode(this.product);

    }

    @RabbitListener(queues="${jsa.rabbitmq.queue4}")
    public void receivedmessagefromuser(User user){
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        System.out.println("recieved user : " +user.toString());
        this.user = user;
        userService.createUser(user);

    }
}
