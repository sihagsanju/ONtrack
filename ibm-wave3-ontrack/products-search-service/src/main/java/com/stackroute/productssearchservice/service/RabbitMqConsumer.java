package com.stackroute.productssearchservice.service;

import com.stackroute.productssearchservice.domain.Brand;
import com.stackroute.productssearchservice.domain.Product;
import com.stackroute.productssearchservice.repository.BrandRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RabbitMqConsumer {

    @Autowired
    BrandRepository brandRepository;
    @RabbitListener(queues="${jsa.rabbitmq.queue1}", containerFactory="jsaFactory")
    public void recievedMessage(Product product) {

        System.out.println("Recieved Message:" +product);
//        System.out.println(user.getPassword());

        if(brandRepository.existsById(product.getBrand()))
        {
            Optional<Brand> productBrand = brandRepository.findById(product.getBrand());
            System.out.println("get the value of list"+ productBrand.get().getList());
            productBrand.get().getList().add(product);
            brandRepository.save(productBrand.get());
            // return productBrand;
//            return productBrand;
        }

        else {
            Brand productBrand= new Brand();
            productBrand.setBrand(product.getBrand());
            List<Product> productList= new ArrayList<>();
            productList.add(product);
            productBrand.setList(productList);
            brandRepository.save(productBrand);
        }


    }
}
