package com.thoughtworks.consumer.configuration;

import com.thoughtworks.consumer.service.RabbitMQConsumer;
import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;

@Configuration
@EnableRabbit
public class ConsumerConfig implements RabbitListenerConfigurer {

    @Bean
    public MappingJackson2MessageConverter jackson2MessageConverter(){
        return new MappingJackson2MessageConverter();
    }
    @Bean
    public DefaultMessageHandlerMethodFactory handlerMethodFactory(){
        DefaultMessageHandlerMethodFactory defaultMessageHandlerMethodFactory = new DefaultMessageHandlerMethodFactory();
        defaultMessageHandlerMethodFactory.setMessageConverter(jackson2MessageConverter());
        return defaultMessageHandlerMethodFactory;
    }

    @Override
    public void configureRabbitListeners(RabbitListenerEndpointRegistrar registrar) {
        registrar.setMessageHandlerMethodFactory(handlerMethodFactory());

    }

    @Autowired
    private RabbitMQConsumer rabbitMQConsumer;

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }


}
