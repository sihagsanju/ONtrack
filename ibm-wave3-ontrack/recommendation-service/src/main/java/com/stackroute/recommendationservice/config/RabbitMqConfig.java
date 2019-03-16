package com.stackroute.recommendationservice.config;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {
    @Bean
    public MessageConverter jsonMessageConverter(){
        return new Jackson2JsonMessageConverter();
    }

//    @Bean
//    public SimpleRabbitListenerContainerFactory jsaFactory(ConnectionFactory connectionFactory,
//                                                           SimpleRabbitListenerContainerFactoryConfigurer configurer) {
//        SimpleRabbitListenerContainerFactory factory =
//                new SimpleRabbitListenerContainerFactory();
//        configurer.configure(factory, connectionFactory);
//        factory.setMessageConverter(jsonMessageConverter());
//        return factory;
//    }
     @Bean
     public AmqpAdmin amqpAdmin(ConnectionFactory connectionFactory)
     {
         return new RabbitAdmin(connectionFactory);
     }
}
