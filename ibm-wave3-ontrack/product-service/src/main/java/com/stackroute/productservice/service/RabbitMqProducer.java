package com.stackroute.productservice.service;

import com.stackroute.rabbitmq.domain.Product;
import com.stackroute.rabbitmq.domain.ProductDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private ProductDTO productDTO;

    @Value("${jsa.rabbitmq.topicexchange}")
    private String topicexchange;

    @Value("${jsa.rabbitmq.routingkey1}")
    private String routingkey1;

    @Value("${jsa.rabbitmq.routingkey2}")
    private String routingkey2;



    public void produce(Product product) {


               rabbitTemplate.convertAndSend(topicexchange, routingkey1, product);
               rabbitTemplate.convertAndSend(topicexchange, routingkey2, product);
               System.out.println("Send msg = ========" + product);

    }
}
