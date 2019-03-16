package com.stackroute.registrationservice.config;



import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {
    @Value("${jsa.rabbitmq.queue3}")
    String queueName3;
    @Value("${jsa.rabbitmq.queue4}")
    String queueName4;
    @Value("${jsa.rabbitmq.topicexchange}")
    String topicexchange;
    @Value("${jsa.rabbitmq.routingkey3}")
    private String routingkey3;
    @Value("${jsa.rabbitmq.routingkey4}")
    private String routingkey4;

    @Bean
    Queue queue3() {
        return new Queue(queueName3, true);
    }
    @Bean
    Queue queue4() {
        return new Queue(queueName4, true);
    }


    @Bean
    TopicExchange exchange() {
        return new TopicExchange(topicexchange);
    }
    @Bean
    public Binding bindinglogin(Queue queue3, TopicExchange topicExchange) {
        return BindingBuilder.bind(queue3).to(topicExchange).with(routingkey3);
    }

    @Bean
    public Binding bindingrecommendation(TopicExchange topicExchange,
                                         Queue queue4) {
        return BindingBuilder.bind(queue4).to(topicExchange).with(routingkey4);
    }
    @Bean
    public MessageConverter jsonMessageConverter(){
        return new Jackson2JsonMessageConverter();
    }


    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }

}